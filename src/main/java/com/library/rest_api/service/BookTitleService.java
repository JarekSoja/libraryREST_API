package com.library.rest_api.service;

import com.library.rest_api.domain.BookTitle;
import com.library.rest_api.repository.BookTitleRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class BookTitleService {

    @Autowired
    BookTitleRepository bookTitleRepository;

    void deleteBooktitle(Long id) {
        bookTitleRepository.deleteById(id);
    }

    List<BookTitle> getBookTitleWithAuthor(String author) {
        return bookTitleRepository.findByAuthor(author);
    }

    List<BookTitle> getBookTitleWithTitle(String title) {
        return bookTitleRepository.findByTitle(title);
    }

    List<BookTitle> getAllTitlesWithAvailableCopies() {
     return bookTitleRepository.retrieveBookTitlesWithAvailableCopies();
    }

}
