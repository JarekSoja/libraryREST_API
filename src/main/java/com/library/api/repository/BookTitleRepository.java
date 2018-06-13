package com.library.api.repository;

import com.library.api.domain.BookTitle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BookTitleRepository extends CrudRepository<BookTitle, Long> {

    void deleteById(Long bookTitleId);

    List<BookTitle> findByAuthor(String author);

    List<BookTitle> findByTitle(String bookTitleTitle);

    List<BookTitle> findAll();

    BookTitle findByBookTitleId(Long id);

    @Query
    List<BookTitle> retrieveBookTitlesWithAvailableCopies();

    List<BookTitle> getAllByYearOfPublishing(int year);

}
