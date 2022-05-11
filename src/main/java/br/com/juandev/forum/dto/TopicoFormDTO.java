package br.com.juandev.forum.dto;

import br.com.juandev.forum.entity.Curso;
import br.com.juandev.forum.entity.Topico;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TopicoFormDTO {

    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull
    @NotEmpty
    private String mensagem;

    @NotNull
    @NotEmpty
    private String nomeCurso;

    public Topico converter(TopicoFormDTO topicoFromDTO, Curso curso) {
        return new Topico(topicoFromDTO.getTitulo(), topicoFromDTO.getMensagem(), curso);
    }
}
