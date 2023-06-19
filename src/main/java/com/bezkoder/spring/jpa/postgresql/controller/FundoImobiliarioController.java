package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.FundoImobiliario;
import com.bezkoder.spring.jpa.postgresql.service.FundoImobiliarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/fiis")
public class FundoImobiliarioController {
	private final FundoImobiliarioService fundoImobiliarioService;

	@Autowired
	public FundoImobiliarioController(FundoImobiliarioService fundoImobiliarioService) {
		this.fundoImobiliarioService = fundoImobiliarioService;
	}

	@GetMapping()
	public ResponseEntity<List<FundoImobiliario>> getAllFiis() {
		try {
			List<FundoImobiliario> fundoImobiliarios = new ArrayList<FundoImobiliario>();

			fundoImobiliarioService.findAll().forEach(fundoImobiliarios::add);

			if (fundoImobiliarios.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(fundoImobiliarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/atualizarFiis")
	public void atualizarFiis(@RequestBody String listaFiis) throws JsonProcessingException {
		fundoImobiliarioService.atualizarFiis(listaFiis);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FundoImobiliario> getFiiByTicker(@PathVariable("id") String id) {
		Optional<FundoImobiliario> fiiData = fundoImobiliarioService.findById(id);

		if (fiiData.isPresent()) {
			return new ResponseEntity<>(fiiData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
