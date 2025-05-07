package com.example.comentario.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

// import org.springframework.beans.factory.annotation.Autowired;

import com.example.comentario.model.Comentario;
import com.example.comentario.repository.ComentarioRepository;
import com.example.comentario.service.ComentarioService;

@Service
public class ComentarioServiceImpl implements ComentarioService{
    private final ComentarioRepository comentarioRepository;

    public ComentarioServiceImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public Comentario crearComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    @Override
    public List<Comentario> findAll() {
        return comentarioRepository.findAll();
    }

    @Override
    public Comentario findById(Long ID) {
        return comentarioRepository.findById(ID).orElse(null);
    }

    @Override
    public Comentario update(Long ID, Comentario texto) {
        Comentario comentario = comentarioRepository.findById(ID).orElse(null);
        if (comentario != null) {
            comentario.setTexto(texto.getTexto());
            return comentarioRepository.save(comentario);
        }
        return null;
    }

    @Override
    public void delete(Long ID) {
        comentarioRepository.deleteById(ID);
    }

    @Override
    public Object listarComentarios() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarComentarios'");
    }

    
}
