package com.example.comentario.service;

import java.util.List;

import com.example.comentario.model.Comentario;

public interface ComentarioService {
    public Comentario crearComentario(Comentario comentario);

    public List<Comentario> findAll();

    public Comentario findById(Long ID);

    public Comentario update(Long ID, Comentario texto);

    public void delete(Long ID);

    public Object listarComentarios();
}
