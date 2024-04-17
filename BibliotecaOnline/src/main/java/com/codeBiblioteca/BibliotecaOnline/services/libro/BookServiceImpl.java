package com.codeBiblioteca.BibliotecaOnline.services.libro;

import com.codeBiblioteca.BibliotecaOnline.entity.Book;
import com.codeBiblioteca.BibliotecaOnline.repository.BookRepository;
import com.codeBiblioteca.BibliotecaOnline.request.CreateBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;
    @Override
    public Book createBook(CreateBookRequest req) {
        Book book = new Book();
        book.setIsbn(req.getIsbn());
        book.setTitle(req.getTitle());
        book.setAuthor(req.getAuthor());
        book.setGenre(req.getGenre());
        book.setPublicationYear(req.getPublicationYear());
        book.setLanguage(req.getLanguage());
        book.setPrice(req.getPrice());
        book.setImages(req.getImages());
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long bookId, CreateBookRequest updateBook) throws Exception {
        Book book = findBookById(bookId);
        book.setIsbn(updateBook.getIsbn());
        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setGenre(updateBook.getGenre());
        book.setPublicationYear(updateBook.getPublicationYear());
        book.setLanguage(updateBook.getLanguage());
        book.setPrice(updateBook.getPrice());
        book.setImages(updateBook.getImages());
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) throws Exception {
        Book book = findBookById(bookId);
        bookRepository.delete(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(Long id) throws Exception {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isEmpty()) {
            throw new Exception("Book not found with id: " + id);
        }
        return optionalBook.get();
    }

    @Override
    public void addImagesToBook(Long bookId, List<String> images) throws Exception {
        Book book = findBookById(bookId);
        List<String> currentImages = book.getImages();
        currentImages.addAll(images);
        book.setImages(currentImages);
        bookRepository.save(book);
    }

    @Override
    public void removeImageFromBook(Long bookId, String imageUrl) throws Exception {
        Book book = findBookById(bookId);
        List<String> currentImages = book.getImages();
        currentImages.remove(imageUrl);
        book.setImages(currentImages);
        bookRepository.save(book);
    }
}
