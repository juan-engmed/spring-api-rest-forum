package br.com.juandev.forum.config.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorFormDTO {

    private String campo;

    private String erro;


}
