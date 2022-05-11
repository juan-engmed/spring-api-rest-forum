package br.com.juandev.forum.dto;

import br.com.juandev.forum.entity.Curso;
import br.com.juandev.forum.entity.Topico;
import lombok.Data;

@Data
public class TopicoFormDTO {

    private String titulo;

    private String mensagem;

    private String nomeCurso;

    public Topico converter(TopicoFormDTO topicoFromDTO, Curso curso) {
        return new Topico(topicoFromDTO.getTitulo(), topicoFromDTO.getMensagem(), curso);
    }
}
