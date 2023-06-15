package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.model.Fii;
import com.bezkoder.spring.jpa.postgresql.repository.FiiRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;


@Service
public class FiiService {
    @Autowired
    private FiiRepository fiiRepository;

    public List<Fii> findAll() {
        return fiiRepository.findAll();
    }

    public void atualizarFiis(String listaFiis) throws JsonProcessingException {
        fiiRepository.deleteAll();

        ObjectMapper objectMapper = new ObjectMapper();
        List<Fii> fiis = objectMapper.readValue(listaFiis, new TypeReference<List<Fii>>(){});

        fiiRepository.saveAll(fiis);
    }

    public Optional<Fii> findById(String id) {
        return fiiRepository.findById(id);
    }

    public Fii save(Fii fii) {
        return fiiRepository.save(fii);
    }

    public void deleteById(String id) {
        fiiRepository.deleteById(id);
    }

    public void deleteAll() {
        fiiRepository.deleteAll();
    }
}
