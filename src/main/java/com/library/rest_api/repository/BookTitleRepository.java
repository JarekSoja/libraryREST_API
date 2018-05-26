package com.library.rest_api.repository;

import com.library.rest_api.domain.BookCopy;
import com.library.rest_api.domain.BookTitle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BookTitleRepository extends CrudRepository<BookTitle, Long> {

    void delete (Long bookTitleId);

    List<BookTitle> findByBookTitleAuthor (String bookTitleAuthor);

    List<BookTitle> findByBookTitleTile (String bookTitleTitle);





}
