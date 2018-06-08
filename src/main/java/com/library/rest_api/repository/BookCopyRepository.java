package com.library.rest_api.repository;

import com.library.rest_api.domain.BookCopy;
import com.library.rest_api.domain.BookTitle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BookCopyRepository extends CrudRepository<BookCopy, Long> {

    void deleteById(Long bookCopyId);

    @Query
    List<BookCopy> fetchAllAvailableCopies();

    List<BookCopy> getAllByBookTitle(Long id);

    BookCopy getByBookCopyId(Long id);

}
