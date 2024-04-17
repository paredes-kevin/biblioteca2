package com.codeBiblioteca.BibliotecaOnline.repository;

import com.codeBiblioteca.BibliotecaOnline.entity.Book;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookPageableRepository extends PagingAndSortingRepository<Book, Long> {
}
