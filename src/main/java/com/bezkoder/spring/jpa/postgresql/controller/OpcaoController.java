package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.Opcao;
import com.bezkoder.spring.jpa.postgresql.service.OpcaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1/opcoes")
public class OpcaoController {
	private final OpcaoService opcaoService;

	@Autowired
	public OpcaoController(OpcaoService opcaoService) {
		this.opcaoService = opcaoService;
	}

	@GetMapping("")
	public ResponseEntity<List<Opcao>> getAllOpcoes() {
		try {
			List<Opcao> opcoes = new ArrayList<Opcao>();

			opcaoService.findAll().forEach(opcoes::add);

			if (opcoes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(opcoes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<List<Opcao>> getOpcao(@PathVariable("id") String id) {
		try {
			Optional<Opcao> opcao = opcaoService.findById(id);

			if (opcao.isEmpty()) {
				return new ResponseEntity(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity(opcao, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/")
	public ResponseEntity<Opcao> createOpcao(@RequestBody Opcao opcao) {
		try {
			Opcao _opcao = opcaoService.save(opcao);
			return new ResponseEntity<>(_opcao, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteOpcao(@PathVariable("id") String id) {
		try {
			opcaoService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/")
	public ResponseEntity<HttpStatus> deleteAllOpcoes() {
		try {
			opcaoService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
