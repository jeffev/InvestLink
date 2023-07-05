package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.model.AcaoUsuario;
import com.bezkoder.spring.jpa.postgresql.repository.AcaoUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcaoUsuarioService {
    @Autowired
    private AcaoUsuarioRepository acaoUsuarioRepository;

    public List<AcaoUsuario> getAll() {
        String login = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return acaoUsuarioRepository.findAllByLogin(login);
    }

    public AcaoUsuario adicionarAcao(AcaoUsuario acaoUsuario) {
        if (acaoUsuario.getQuantidade() == 0) {
            throw new IllegalArgumentException("A quantidade da ação deve ser maior que zero.");
        }

        if (acaoUsuario.getPrecoMedio() == 0) {
            throw new IllegalArgumentException("O preço médio da ação deve ser maior que zero.");
        }

        Optional<AcaoUsuario> acaoExistente = acaoUsuarioRepository.findByTickerAndLogin(
                acaoUsuario.getTicker(), acaoUsuario.getLogin());

        if (acaoExistente.isPresent()) {
            throw new IllegalArgumentException("A ação já existe para o usuário, favor atualizar a quantidade.");
        }

        return acaoUsuarioRepository.save(acaoUsuario);
    }

    public void removerAcao(Integer id) {
        acaoUsuarioRepository.deleteById(id);
    }

    public AcaoUsuario editarAcao(AcaoUsuario acaoUsuario) {
        if (acaoUsuario.getQuantidade() == 0) {
            throw new IllegalArgumentException("A quantidade da ação deve ser maior que zero.");
        }

        if (acaoUsuario.getPrecoMedio() == 0) {
            throw new IllegalArgumentException("O preço médio da ação deve ser maior que zero.");
        }

        return acaoUsuarioRepository.save(acaoUsuario);
    }
}
