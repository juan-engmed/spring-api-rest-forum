package br.com.juandev.forum.repository;


import br.com.juandev.forum.entity.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}
