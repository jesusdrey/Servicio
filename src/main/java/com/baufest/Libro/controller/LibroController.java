package com.baufest.Libro.controller;


import com.baufest.Libro.Interfa.LibroServicio;
import com.baufest.Libro.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
        try{
            if (libro.getNombre().isEmpty() || libro.getAutor().isEmpty() || libro.getPaginas() == 0) {
                mensaje = "No puede haber campos vacios";
            }
            else {
                this.libroServicio.addLibro(libro);
            }
        }catch(javax.validation.UnexpectedTypeException e){
            mensaje="Registro Duplicado";
        }

        return mensaje;
    }
    @RequestMapping(value = "Libro/{id}",method = RequestMethod.GET)
    public Optional getLibrosById(@PathVariable(value = "id") Long id){

        return libroServicio.getLibroById(id);
    }


  /*  @RequestMapping(value = "Libro",method = RequestMethod.DELETE)
    public
*/

}
