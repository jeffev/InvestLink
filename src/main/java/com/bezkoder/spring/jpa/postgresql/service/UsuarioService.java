package com.bezkoder.spring.jpa.postgresql.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bezkoder.spring.jpa.postgresql.model.Usuario;
import com.bezkoder.spring.jpa.postgresql.repository.UsuarioRepository;
import com.bezkoder.spring.jpa.postgresql.resources.UsuarioExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import static com.bezkoder.spring.jpa.postgresql.enums.Role.USUARIO;
import static com.bezkoder.spring.jpa.postgresql.security.JWTAutenticarFilter.TOKEN_EXPIRACAO;
import static com.bezkoder.spring.jpa.postgresql.security.JWTAutenticarFilter.TOKEN_SENHA;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario (Usuario usuario) {
        Usuario u = usuarioRepository.findByLogin(usuario.getLogin());

        if (u != null) {
            throw new UsuarioExistenteException("Usuário já existe");
        } else {
            usuario.setRole(USUARIO);
            usuarioRepository.save(usuario);

            String token = JWT.create().
                    withSubject(usuario.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRACAO))
                    .sign(Algorithm.HMAC512(TOKEN_SENHA));

            usuario.setToken(token);
        }

        return usuario;
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
