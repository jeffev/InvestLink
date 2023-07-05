package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.AcaoUsuario;
import com.bezkoder.spring.jpa.postgresql.service.AcaoUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/acao-usuario")
public class AcaoUsuarioController {

    private AcaoUsuarioService acaoUsuarioService;

    public AcaoUsuarioController(AcaoUsuarioService acaoUsuarioService) {
        this.acaoUsuarioService = acaoUsuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<AcaoUsuario>> getAll() {
        try {
            List<AcaoUsuario> acaoUsuarios = acaoUsuarioService.getAll();
            return new ResponseEntity<>(acaoUsuarios, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/adicionar/")
    public ResponseEntity<AcaoUsuario> adicionarAcao(@RequestBody AcaoUsuario acaoUsuario) {
        try {
            AcaoUsuario novaAcaoUsuario = acaoUsuarioService.adicionarAcao(acaoUsuario);
            return new ResponseEntity<>(novaAcaoUsuario, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Void> removerAcao(@PathVariable("id") Integer id) {
        try {
            acaoUsuarioService.removerAcao(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping()
    public ResponseEntity<AcaoUsuario> editarAcao(@RequestBody AcaoUsuario acaoUsuario) {
        try {
            AcaoUsuario acaoUsuarioEditada = acaoUsuarioService.editarAcao(acaoUsuario);
            return new ResponseEntity<>(acaoUsuarioEditada, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
