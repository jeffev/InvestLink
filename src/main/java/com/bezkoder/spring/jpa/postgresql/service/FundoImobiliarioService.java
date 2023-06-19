package com.bezkoder.spring.jpa.postgresql.service;

import com.bezkoder.spring.jpa.postgresql.model.FundoImobiliario;
import com.bezkoder.spring.jpa.postgresql.repository.FundoImobiliarioRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import com.fasterxml.jackson.core.type.TypeReference;


@Service
public class FundoImobiliarioService {
    @Autowired
    private FundoImobiliarioRepository fundoImobiliarioRepository;

    public List<FundoImobiliario> findAll() {
        return fundoImobiliarioRepository.findAll();
    }

    public void atualizarFiis(String listaFiis) throws JsonProcessingException {
        fundoImobiliarioRepository.deleteAll();

        ObjectMapper objectMapper = new ObjectMapper();
        List<FundoImobiliario> fundoImobiliarios = objectMapper.readValue(listaFiis, new TypeReference<List<FundoImobiliario>>(){});

        fundoImobiliarioRepository.saveAll(fundoImobiliarios);
    }

    public Optional<FundoImobiliario> findById(String id) {
        return fundoImobiliarioRepository.findById(id);
    }

    public FundoImobiliario save(FundoImobiliario fundoImobiliario) {
        return fundoImobiliarioRepository.save(fundoImobiliario);
    }

    public void deleteById(String id) {
        fundoImobiliarioRepository.deleteById(id);
    }

    public void deleteAll() {
        fundoImobiliarioRepository.deleteAll();
    }
}
