package com.codeBiblioteca.BibliotecaOnline.services.libro;

import com.codeBiblioteca.BibliotecaOnline.entity.Book;
import com.codeBiblioteca.BibliotecaOnline.repository.BookRepository;
import com.codeBiblioteca.BibliotecaOnline.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface BookService {
    Book createBook(CreateBookRequest req);
    Book updateBook(Long bookId, CreateBookRequest updateBook) throws Exception;
    void deleteBook(Long bookId) throws Exception;
    List<Book> getAllBooks();
    Book findBookById(Long id) throws Exception;
    void addImagesToBook(Long bookId, List<String> images) throws Exception;
    void removeImageFromBook(Long bookId, String imageUrl) throws Exception;
}