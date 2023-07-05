package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.Acao;
import com.bezkoder.spring.jpa.postgresql.service.AcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/acoes")
public class AcaoController {
	private final AcaoService acaoService;

	@Autowired
	public AcaoController(AcaoService acaoService) {
		this.acaoService = acaoService;
	}

	@GetMapping("")
	public ResponseEntity<List<Acao>> getAllAcoes() {
		try {
			List<Acao> acoes = new ArrayList<Acao>();

			acaoService.findAllFormulaMagica().forEach(acoes::add);

			if (acoes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(acoes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/atualizarAcoes")
	public void atualizarAcoes(@RequestParam("file") MultipartFile file) throws IOException, ParseException {
		acaoService.atualizarAcoes(file);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Acao> getAcaoByTicker(@PathVariable("id") String id) {
		Acao acao = acaoService.findById(id);

		if (acao != null) {
			return new ResponseEntity<>(acao, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
