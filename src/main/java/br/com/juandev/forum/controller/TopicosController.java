package br.com.juandev.forum.controller;

import br.com.juandev.forum.dto.TopicoDTO;
import br.com.juandev.forum.entity.Curso;
import br.com.juandev.forum.entity.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista(){

    Topico topico = new Topico("Dúúúvida", "Duvida com Spring",
            new Curso("Spring", "Programação"));

    return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
    }

}
