package br.com.juandev.forum.controller;

import br.com.juandev.forum.dto.TopicoDTO;
import br.com.juandev.forum.dto.TopicoFormDTO;
import br.com.juandev.forum.entity.Topico;
import br.com.juandev.forum.repository.CursoRepository;
import br.com.juandev.forum.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public List<TopicoDTO> lista(String nomeCurso){

        List<Topico> topicos = repository.findAll();

        return TopicoDTO.converter(topicos);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void saveTopico(@RequestBody @Valid TopicoFormDTO topicoFromDTO){

        var curso = cursoRepository.findByNome(topicoFromDTO.getNomeCurso());

       Topico topico = topicoFromDTO.converter(topicoFromDTO, curso);

       repository.save(topico);

    }

}
