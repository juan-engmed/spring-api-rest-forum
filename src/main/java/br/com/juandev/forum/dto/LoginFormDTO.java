package br.com.juandev.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginFormDTO {

    @NotNull
    private String email;

    @NotNull
    private String password;
}
