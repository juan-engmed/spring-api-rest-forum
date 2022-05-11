package br.com.juandev.forum.dto;

import br.com.juandev.forum.entity.Topico;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopicoDTO {


    private Long id;

    private String titulo;

    private String mensagem;

    private LocalDateTime dataCriacao;

    public TopicoDTO(Topico topico){
        this.id = topico.getId();
        this.titulo = topico.getTitulo();
        this.mensagem = topico.getMensagem();
        this.dataCriacao = topico.getDataCriacao();
    }

    public static List<TopicoDTO> converter(List<Topico> topicos) {

        return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());
    }
}
