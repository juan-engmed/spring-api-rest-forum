package br.com.juandev.forum.repository;


import br.com.juandev.forum.entity.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);

    Page<Topico> findByCursoNomeContaining(String nomeCurso, Pageable paginacao);
}
