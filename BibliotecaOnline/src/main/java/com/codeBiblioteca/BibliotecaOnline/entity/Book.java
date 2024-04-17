package com.codeBiblioteca.BibliotecaOnline.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "codigo")
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private Integer publicationYear;
    private String language;
    private Double price;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images = new ArrayList<>();
}
