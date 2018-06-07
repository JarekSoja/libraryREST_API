package com.library.rest_api.service;

import com.library.rest_api.domain.BookCopy;
import com.library.rest_api.repository.BookCopyRepository;
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

    void deleteCopy(Long id) {
        bookCopyRepository.deleteById(id);
    }

    List<BookCopy> getAllAvailableCopies() {
        return bookCopyRepository.fetchAllAvailableCopies();
    }
}
