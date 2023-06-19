package com.bezkoder.spring.jpa.postgresql.repository;


import com.bezkoder.spring.jpa.postgresql.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {

    public UsuarioModel findByLogin(String login);

}
