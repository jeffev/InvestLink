package com.bezkoder.spring.jpa.postgresql.controller;

import com.bezkoder.spring.jpa.postgresql.model.Usuario;
import com.bezkoder.spring.jpa.postgresql.resources.UsuarioExistenteException;
import com.bezkoder.spring.jpa.postgresql.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PasswordEncoder encoder;

    public UsuarioController(UsuarioService usuarioService, PasswordEncoder encoder) {
        this.usuarioService = usuarioService;
        this.encoder = encoder;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }

    @PostMapping("/adicionarFavorita/{ticker}")
    public ResponseEntity<?> adicionarFavorita(@PathVariable("ticker") String ticker) {
        try {
            usuarioService.adicionarFavorita(ticker);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/removerFavorita/{ticker}")
    public ResponseEntity<?> removerFavorita(@PathVariable("ticker") String ticker) {
        try {
            usuarioService.removerFavorita(ticker);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RestControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(UsuarioExistenteException.class)
        public ResponseEntity<String> handleUsuarioExistenteException(UsuarioExistenteException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }
}
