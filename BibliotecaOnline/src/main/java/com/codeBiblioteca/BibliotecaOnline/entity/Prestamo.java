package com.codeBiblioteca.BibliotecaOnline.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book libro;

    @ManyToOne
    private User user;

    private Date fechaPrestamo;
    private Date fechaDevolucion;


}
