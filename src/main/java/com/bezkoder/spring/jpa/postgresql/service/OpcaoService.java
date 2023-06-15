package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.model.Opcao;
import com.bezkoder.spring.jpa.postgresql.repository.OpcaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OpcaoService {
    @Autowired
    private OpcaoRepository opcaoRepository;

    public List<Opcao> findAll() {
        return opcaoRepository.findAll();
    }

    public Optional<Opcao> findById(String id) {
        return opcaoRepository.findById(id);
    }

    public Opcao save(Opcao opcao) {
        return opcaoRepository.save(opcao);
    }

    public void deleteById(String id) {
        opcaoRepository.deleteById(id);
    }

    public void deleteAll() {
        opcaoRepository.deleteAll();
    }
}
