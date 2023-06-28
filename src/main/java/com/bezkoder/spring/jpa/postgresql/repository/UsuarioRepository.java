package com.bezkoder.spring.jpa.postgresql.repository;


import com.bezkoder.spring.jpa.postgresql.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByLogin(String login);

}
