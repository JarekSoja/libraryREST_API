package com.library.rest_api.controller;

import com.library.rest_api.dto.BookCopyDto;
import com.library.rest_api.dto.BookTitleDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/books")
@RestController
public class BookController {

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

    //TODO Search all titles with available copies

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


    //TODO Return total number of particular title copies divided to available and unavailable.

    //TODO Return all available copies, regardless of title.

    //TODO Return all overdue copies.


}
