package com.baufest.Libro.controller;


import com.baufest.Libro.Interfa.LibroServicio;
import com.baufest.Libro.model.Libro;
import com.baufest.Libro.repository.LibroRepository;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import com.baufest.Libro.excepciones.*;


@RestController
@RequestMapping("/api")
public class LibroController {
    private LibroServicio libroServicio;

    @Autowired
    public void setLibroServicio(LibroServicio libroServicio){
        this.libroServicio=libroServicio;
    }

    @RequestMapping(value = "Libro",method = RequestMethod.GET)
    public List getLibros(){
        return libroServicio.getLibro();
    }

    @RequestMapping(value = "Libro", method = RequestMethod.POST)
    public String addLibro(@ModelAttribute Libro libro){
        String mensaje = "Libro creado exitosamente";
        if (libro.getNombre().isEmpty() || libro.getAutor().isEmpty()) {
            mensaje = "No puede haber campos vacios";
        } else {
            this.libroServicio.addLibro(libro);
        }
        return mensaje;
    }

  /*  @RequestMapping(value = "Libro",method = RequestMethod.DELETE)
    public
*/

}
