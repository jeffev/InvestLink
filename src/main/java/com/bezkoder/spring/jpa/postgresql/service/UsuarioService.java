package com.bezkoder.spring.jpa.postgresql.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bezkoder.spring.jpa.postgresql.model.Acao;
import com.bezkoder.spring.jpa.postgresql.model.Usuario;
import com.bezkoder.spring.jpa.postgresql.repository.UsuarioRepository;
import com.bezkoder.spring.jpa.postgresql.resources.CustomException;
import com.bezkoder.spring.jpa.postgresql.resources.UsuarioExistenteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.bezkoder.spring.jpa.postgresql.enums.Role.USUARIO;
import static com.bezkoder.spring.jpa.postgresql.security.JWTAutenticarFilter.TOKEN_EXPIRACAO;
import static com.bezkoder.spring.jpa.postgresql.security.JWTAutenticarFilter.TOKEN_SENHA;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AcaoService acaoService;

    public Usuario findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

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

    public void adicionarFavorita(String ticker) {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            throw new CustomException("Usuário não encontrado.");
        }

        Acao acao = acaoService.findById(ticker);
        if (acao == null) {
            throw new CustomException("Ação não encontrada.");
        }

        List<Acao> acoesFavoritas = usuario.getAcoesFavoritas();
        if (!acoesFavoritas.contains(acao)) {
            acoesFavoritas.add(acao);
            usuarioRepository.save(usuario);
        } else {
            throw new CustomException("Ação já esta nas favoritas do usuário.");
        }
    }

    public void removerFavorita(String ticker) {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            throw new CustomException("Usuário não encontrado.");
        }

        Acao acao = acaoService.findById(ticker);
        if (acao == null) {
            throw new CustomException("Ação não encontrada.");
        }

        List<Acao> acoesFavoritas = usuario.getAcoesFavoritas();
        boolean removed = acoesFavoritas.remove(acao);

        if (!removed) {
            throw new CustomException("Ação não encontrada na lista de favoritas do usuário.");
        }

        usuarioRepository.save(usuario);
    }

}
