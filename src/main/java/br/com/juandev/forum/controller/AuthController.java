package br.com.juandev.forum.controller;

import br.com.juandev.forum.dto.LoginFormDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    @PostMapping
    public ResponseEntity<?> autenticar(@RequestBody @Valid LoginFormDTO loginFormDTO) {

    }
}
