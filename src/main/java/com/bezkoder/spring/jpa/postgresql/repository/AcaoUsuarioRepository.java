package com.bezkoder.spring.jpa.postgresql.repository;

import com.bezkoder.spring.jpa.postgresql.model.AcaoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AcaoUsuarioRepository extends JpaRepository<AcaoUsuario, Integer> {

    @Query("SELECT au FROM AcaoUsuario au WHERE au.ticker = :ticker AND au.login = :login")
    Optional<AcaoUsuario> findByTickerAndLogin(@Param("ticker") String ticker, @Param("login") String login);

    @Query("SELECT au FROM AcaoUsuario au WHERE au.login = :login")
    List<AcaoUsuario> findAllByLogin(@Param("login") String login);
}
