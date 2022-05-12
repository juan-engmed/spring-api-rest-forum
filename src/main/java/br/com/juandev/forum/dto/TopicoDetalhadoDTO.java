package br.com.juandev.forum.dto;

import br.com.juandev.forum.entity.StatusTopico;
import br.com.juandev.forum.entity.Topico;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicoDetalhadoDTO {

    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    private String nomeAutor;

    private StatusTopico status;

    private List<RespostaDTO> respostas = new ArrayList<>();

    public TopicoDetalhadoDTO(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
        this.nomeAutor = topico.getAutor() != null ? topico.getAutor().getNome() : "" ;
        this.status = topico.getStatus();
        this.respostas = topico.getRespostas().stream()
                .map(RespostaDTO::new)
                .collect(Collectors.toList());
    }
}
