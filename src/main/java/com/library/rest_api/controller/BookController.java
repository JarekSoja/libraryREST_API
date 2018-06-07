package com.library.rest_api.controller;

import com.library.rest_api.dto.BookCopyDto;
import com.library.rest_api.dto.BookTitleDto;
import com.library.rest_api.mapper.BookCopyMapper;
import com.library.rest_api.mapper.BookTitleMapper;
import com.library.rest_api.repository.BookCopyRepository;
import com.library.rest_api.repository.BookTitleRepository;
import com.library.rest_api.service.BookCopyService;
import com.library.rest_api.service.BookTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    BookCopyMapper bookCopyMapper;

    @Autowired
    BookTitleMapper bookTitleMapper;

    @Autowired
    BookCopyService bookCopyService;

    @Autowired
    BookTitleService bookTitleService;

    @GetMapping
    List<BookTitleDto> getAllBookTitles() {
        return new ArrayList<>();
    }

    @GetMapping(value = "/{id}")
    BookTitleDto getBookTitleDetailId(@PathVariable("id") Long bookTitleId) {
        return null;
    }

    @PostMapping
    BookTitleDto newBookTitle(@RequestBody BookTitleDto bookTitleDto) {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    void removeBookTitle(@PathVariable("id") Long bookTitleId) {
    }

    @PutMapping(value = "/{id}")
    BookTitleDto updateBookTitle(@PathVariable("id") Long bookCopyId, @RequestBody BookTitleDto bookTitleDto) {
        return null;
    }

    @GetMapping(value = "/search")
    List<BookTitleDto> findBookTitles(@RequestParam(value = "author", required = false) String author,
                                      @RequestParam(value = "title", required = false) String title) {
        return null;
    }

    @GetMapping(value = "/available")
    List<BookTitleDto> retrieveBookTitlesWithAvailableCopies() {
        return null;
    }

    @GetMapping(value = "/copies")
    List<BookCopyDto> getAllBookCopies(@PathVariable("id") Long bookTitleId) {
        return null;
    }

    @GetMapping(value = "/{id}/copies/{copyId}")
    BookTitleDto getBookTitleDetaild(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
        return null;
    }

    @PostMapping(value = "/copies")
    BookCopyDto newBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        return null;
    }

    @DeleteMapping(value = "/{id}/copies/{copyId}")
    void removeBookTitle(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
    }

    @PutMapping(value = "/{id}/copies/{copyId}")
    BookTitleDto updateBookTitle(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
        return null;
    }

    @GetMapping(value = "/copies/{id}")
    List<BookTitleDto> findBookTitles(@PathVariable("id") Long bookTitleId,
                                      @RequestParam(value = "year", required = false) Integer yearOfPublishing,
                                      @RequestParam(value = "isAvailabe", required = false) boolean isAvailable) {
        return null;
    }

    @GetMapping(value = "/availableCopies")
    List<BookCopyDto> fetchAllAvailableCopies() {
        return null;
    }
}
