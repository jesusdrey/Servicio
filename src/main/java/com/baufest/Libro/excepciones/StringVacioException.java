package com.baufest.Libro.excepciones;

public class StringVacioException extends Exception {
    public StringVacioException() {
        super("No puede haber campos vacios.");
    }
}
