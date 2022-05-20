package br.com.juandev.forum.controller;

import br.com.juandev.forum.config.validation.SearchNotFoundException;
import br.com.juandev.forum.dto.TopicoDTO;
import br.com.juandev.forum.dto.TopicoDetalhadoDTO;
import br.com.juandev.forum.dto.TopicoFormDTO;
import br.com.juandev.forum.dto.UpdateTopicoFormDTO;
import br.com.juandev.forum.entity.Topico;
import br.com.juandev.forum.repository.CursoRepository;
import br.com.juandev.forum.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topicos")
@Validated
public class TopicosController {

    private final TopicoRepository repository;

    private final CursoRepository cursoRepository;

    @GetMapping()
    public Page<TopicoDTO> lista(@RequestParam(required = false) String nomeCurso,
                                 @RequestParam int pagina, @RequestParam int qtd){

        Pageable paginacao = PageRequest.of(pagina, qtd);

        if(nomeCurso == null) {
            Page<Topico> topicos = repository.findAll(paginacao);
            return TopicoDTO.converter(topicos);
        }

        else{
            Page<Topico> topicos = repository.findByCursoNomeContaining(nomeCurso, paginacao);
            return TopicoDTO.converter(topicos);
        }
    }

    @GetMapping("/{id}")
    public TopicoDetalhadoDTO getTopico(@PathVariable("id") Long id){
        var topico = repository.findById(id).
                orElseThrow(() -> new SearchNotFoundException("Tópico", id));

        return new TopicoDetalhadoDTO(topico);

    }

    @PostMapping()
    @Transactional
    @ResponseStatus(code = HttpStatus.CREATED)
    public TopicoDTO saveTopico(@RequestBody @Valid TopicoFormDTO topicoFromDTO){

        var curso = cursoRepository.findByNome(topicoFromDTO.getNomeCurso());

       Topico topico = topicoFromDTO.converter(topicoFromDTO, curso);

       return new TopicoDTO(repository.save(topico));

    }

    @PutMapping("/{id}")
    @Transactional
    public TopicoDTO updateTopico(@PathVariable("id") Long id, @RequestBody @Valid UpdateTopicoFormDTO updateTopicoFormDTO ) {
        var topico = repository.findById(id).
                orElseThrow(() -> new SearchNotFoundException("Tópico", id));

        topico.setTitulo(updateTopicoFormDTO.getTitulo());
        topico.setMensagem(updateTopicoFormDTO.getMensagem());

        return new TopicoDTO(repository.save(topico));

    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTopico(@PathVariable("id") Long id){
        var topico = repository.findById(id).
                orElseThrow(() -> new SearchNotFoundException("Tópico", id));

        repository.deleteById(topico.getId());
    }

}
