package com.codeBiblioteca.BibliotecaOnline.controller.auth;
import com.codeBiblioteca.BibliotecaOnline.entity.Book;
import com.codeBiblioteca.BibliotecaOnline.request.CreateBookRequest;
import com.codeBiblioteca.BibliotecaOnline.services.libro.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookUno;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest request) {
        Book createdBook = bookUno.createBook(request);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) throws Exception {
        Book book = bookUno.findBookById(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody CreateBookRequest request) throws Exception {
        Book updatedBook = bookUno.updateBook(id, request);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) throws Exception {
        bookUno.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookUno.getAllBooks();
        return ResponseEntity.ok(books);
    }

}
