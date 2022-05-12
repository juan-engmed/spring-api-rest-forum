package br.com.juandev.forum.dto;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.validation.constraints.NotEmpty;


@Data
public class UpdateTopicoFormDTO {

    @NotNull
    @NotEmpty
    private String titulo;

    @NotNull
    @NotEmpty
    private String mensagem;


}
