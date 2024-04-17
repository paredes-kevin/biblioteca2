package com.codeBiblioteca.BibliotecaOnline.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateBookRequest {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private Integer publicationYear;
    private String language;
    private Double price;
    private List<String> images;
}
