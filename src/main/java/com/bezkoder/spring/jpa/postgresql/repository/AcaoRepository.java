package com.bezkoder.spring.jpa.postgresql.repository;

import com.bezkoder.spring.jpa.postgresql.model.Acao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoRepository extends JpaRepository<Acao, String> {

}
