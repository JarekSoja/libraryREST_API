package com.library.api.repository;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
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
    List<BookCopy> getBookCopiesByAvailable();

    List<BookCopy> getAllByIsAvailable(boolean param);

    List<BookCopy> getAllByBookTitle(BookTitle bookTitle);

    BookCopy getByBookCopyId(Long id);

}
