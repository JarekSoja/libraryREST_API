package com.library.api.service;

import com.library.api.domain.BookTitle;
import com.library.api.repository.BookTitleRepository;
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

    public List<BookTitle> getAllBookTitles() {
        return bookTitleRepository.findAll();
    }

    public void deleteBooktitle(Long id) {
        bookTitleRepository.deleteById(id);
    }

    public List<BookTitle> getBookTitleWithAuthor(String author) {
        return bookTitleRepository.findByAuthor(author);
    }

    public List<BookTitle> getBookTitleWithTitle(String title) {
        return bookTitleRepository.findByTitle(title);
    }

    public List<BookTitle> getAllTitlesWithAvailableCopies() {
        return bookTitleRepository.retrieveBookTitlesWithAvailableCopies();
    }

    public BookTitle getBookTitleById(Long id) {
        return bookTitleRepository.findByBookTitleId(id);
    }

    public BookTitle saveBookTitle(BookTitle bookTitle) {
        return bookTitleRepository.save(bookTitle);
    }

    public List<BookTitle> getAllTitlesWithGivenPublishingYear(int year) {
        return bookTitleRepository.getAllByYearOfPublishing(year);
    }

}
