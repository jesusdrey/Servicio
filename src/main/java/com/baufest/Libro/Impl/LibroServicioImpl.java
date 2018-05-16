package com.baufest.Libro.Impl;

import com.baufest.Libro.Interfa.LibroServicio;
import com.baufest.Libro.model.Libro;
import com.baufest.Libro.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LibroServicioImpl implements LibroServicio {
    @Autowired
    private LibroRepository libroRepository;

    @Transactional
    public void addLibro(Libro libro){
        libroRepository.save(libro);
    }

    public List getLibro(){
                return libroRepository.findAll();
    }
}
