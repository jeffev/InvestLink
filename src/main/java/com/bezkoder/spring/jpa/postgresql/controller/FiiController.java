package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.Fii;
import com.bezkoder.spring.jpa.postgresql.service.FiiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/v1")
public class FiiController {
	private final FiiService fiiService;

	@Autowired
	public FiiController(FiiService fiiService) {
		this.fiiService = fiiService;
	}

	@GetMapping("/fiis")
	public ResponseEntity<List<Fii>> getAllFiis() {
		try {
			List<Fii> fiis = new ArrayList<Fii>();

			fiiService.findAll().forEach(fiis::add);

			if (fiis.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(fiis, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/atualizarFiis")
	public void atualizarFiis(@RequestBody String listaFiis) throws JsonProcessingException {
		fiiService.atualizarFiis(listaFiis);
	}

	@GetMapping("/fiis/{id}")
	public ResponseEntity<Fii> getFiiByTicker(@PathVariable("id") String id) {
		Optional<Fii> fiiData = fiiService.findById(id);

		if (fiiData.isPresent()) {
			return new ResponseEntity<>(fiiData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/fiis")
	public ResponseEntity<Fii> createFii(@RequestBody Fii fii) {
		try {
			Fii _fii = fiiService.save(fii);
			return new ResponseEntity<>(_fii, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/fiis/{id}")
	public ResponseEntity<HttpStatus> deleteFii(@PathVariable("id") String id) {
		try {
			fiiService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/fiis")
	public ResponseEntity<HttpStatus> deleteAllFiis() {
		try {
			fiiService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
