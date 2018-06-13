package com.library.api.service;

import com.library.api.domain.BookCopy;
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

    public List<BookCopy> getAllAvailableCopies() {
        return bookCopyRepository.fetchAllAvailableCopies();
    }

    public List<BookCopy> getAllCopiesOfTitle(Long id) {
        return bookCopyRepository.getAllByBookTitle(id);
    }

    public BookCopy getBookCopyById(Long id) {
        return bookCopyRepository.getByBookCopyId(id);
    }

    public BookCopy saveCopy(BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }
}