package com.bezkoder.spring.jpa.postgresql.repository;

import com.bezkoder.spring.jpa.postgresql.model.Acao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AcaoRepository extends JpaRepository<Acao, String> {

    public Acao findByTicker(String ticker);

    @Query("SELECT u.acoesFavoritas FROM Usuario u WHERE u.login = :login")
    List<Acao> findAcoesFavoritasByUsuarioId(@Param("login") String login);


}
