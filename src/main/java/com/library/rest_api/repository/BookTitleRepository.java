package com.library.rest_api.repository;

import com.library.rest_api.domain.BookTitle;
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

    @Query
    List<BookTitle> retrieveBookTitlesWithAvailableCopies();

}
