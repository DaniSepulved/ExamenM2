package com.example.comentario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.comentario.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long>{
    @SuppressWarnings("null")
    Optional<Comentario> findById(Long id);
}
