package com.baufest.Libro.Interfa;

import com.baufest.Libro.model.Libro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LibroServicio {

    void addLibro(Libro libro);
    List getLibro();

}
