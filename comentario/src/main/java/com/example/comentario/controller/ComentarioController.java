package com.example.comentario.controller;

import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.comentario.model.Comentario;
import com.example.comentario.service.ComentarioService;

@RestController
@RequestMapping("/api/comentario")
public class ComentarioController {
    private final ComentarioService comentarioService;

    public ComentarioController(ComentarioService comentarioService) {
        this.comentarioService = comentarioService;
    }

    @PostMapping
    public ResponseEntity<Comentario> crearComentario(@RequestBody Comentario comentario) {
        Comentario nuevoComentario = comentarioService.crearComentario(comentario);
        return ResponseEntity.ok(nuevoComentario);
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> listarComentarios() {
        List<Comentario> comentarios = comentarioService.findAll();
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> obtenerComentarioPorId(@PathVariable Long id) {
        Comentario comentario = comentarioService.findById(id);
        if (comentario != null) {
            return ResponseEntity.ok(comentario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comentario> actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentario) {
        Comentario comentarioActualizado = comentarioService.update(id, comentario);
        if (comentarioActualizado != null) {
            return ResponseEntity.ok(comentarioActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComentario(@PathVariable Long id) {
        comentarioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
