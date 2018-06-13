package com.library.api.service;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.repository.BookCopyRepository;
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
public class BookCopyService {

    @Autowired
    BookCopyRepository bookCopyRepository;

    public void deleteCopy(Long id) {
        bookCopyRepository.deleteById(id);
    }

    public List<BookCopy> getAllByAvailable(boolean param) {
        return bookCopyRepository.getAllByIsAvailable(param);
    }

    public List<BookCopy> getAllCopiesOfTitle(BookTitle bookTitle) {
        return bookCopyRepository.getAllByBookTitle(bookTitle);
    }

    public BookCopy getBookCopyById(Long id) {
        return bookCopyRepository.getByBookCopyId(id);
    }

    public BookCopy saveCopy(BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }
}
