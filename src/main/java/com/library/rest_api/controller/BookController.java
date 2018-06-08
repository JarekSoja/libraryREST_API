package com.library.rest_api.controller;

import com.library.rest_api.dto.BookCopyDto;
import com.library.rest_api.dto.BookTitleDto;
import com.library.rest_api.mapper.BookCopyMapper;
import com.library.rest_api.mapper.BookTitleMapper;
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
    public BookCopyMapper bookCopyMapper;

    @Autowired
    public BookTitleMapper bookTitleMapper;

    @Autowired
    public BookCopyService bookCopyService;

    @Autowired
    public BookTitleService bookTitleService;

    @GetMapping
    public List<BookTitleDto> getAllBookTitles() {
        return bookTitleMapper.mapToBookTitleDtoList(bookTitleService.getAllBookTitles());
    }

    @GetMapping(value = "/{id}")
    public BookTitleDto getBookTitleDetailId(@PathVariable("id") Long bookTitleId) {
        return bookTitleMapper.mapToBookTitleDto(bookTitleService.getBookTitleById(bookTitleId));
    }

    @PostMapping
    public void createBookTitle(@RequestBody BookTitleDto bookTitleDto) {
        bookTitleService.saveBookTitle(bookTitleMapper.mapToBookTitle(bookTitleDto));
    }

    @DeleteMapping(value = "/{id}")
    public void removeBookTitle(@PathVariable("id") Long bookTitleId) {
        bookTitleService.deleteBooktitle(bookTitleId);
    }

    @PutMapping(value = "/{id}")
    public BookTitleDto updateBookTitle(@PathVariable("id") Long bookCopyId, @RequestBody BookTitleDto bookTitleDto) {
        return bookTitleMapper.mapToBookTitleDto(bookTitleService.saveBookTitle(bookTitleMapper.mapToBookTitle(bookTitleDto)));
    }

    @GetMapping(value = "/search")
    public List<BookTitleDto> findBookTitles(@RequestParam(value = "author", required = false) String author,
                                             @RequestParam(value = "title", required = false) String title) {
        List<BookTitleDto> result = new ArrayList<>();
        if (author.equals(null) && title.equals(null)) {
            return result;
        } else if (!author.equals(null)) {
            result.addAll(bookTitleMapper.mapToBookTitleDtoList(bookTitleService.getBookTitleWithAuthor(author)));
            if (!title.equals(null)) {
                result.addAll(bookTitleMapper.mapToBookTitleDtoList(bookTitleService.getBookTitleWithTitle(title)));
            }
        }
        return result;
    }

    @GetMapping(value = "/available")
    public List<BookTitleDto> retrieveBookTitlesWithAvailableCopies() {
        return bookTitleMapper.mapToBookTitleDtoList(bookTitleService.getAllTitlesWithAvailableCopies());
    }

    @GetMapping(value = "/{id}/copies/{copyId}")
    public BookCopyDto getBookCopyDetailId(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
        return bookCopyMapper.mapToBookCopyDto(bookCopyService.getBookCopyById(bookCopyId));
    }

    @GetMapping(value = "/copies")
    public List<BookCopyDto> getAllBookCopiesByTitle(@PathVariable("id") Long bookTitleId) {
        return bookCopyMapper.mapToBookCopyDtoList(bookCopyService.getAllCopiesOfTitle(bookTitleId));
    }

    @PostMapping(value = "/copies")
    public void newBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        bookCopyService.saveCopy(bookCopyMapper.mapToBookCopy(bookCopyDto));
    }

    @DeleteMapping(value = "/{id}/copies/{copyId}")
    public void removeBookTitle(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
        bookTitleService.deleteBooktitle(bookCopyId);
    }

    @PutMapping(value = "/{id}/copies/{copyId}")
    public BookCopyDto updateBookCopy( @PathVariable("copyId") Long bookCopyId, @RequestBody BookCopyDto bookCopyDto) {
        return bookCopyMapper.mapToBookCopyDto(bookCopyService.saveCopy(bookCopyMapper.mapToBookCopy(bookCopyDto)));

    }

    @GetMapping(value = "/copies/year")
    public List<BookTitleDto> findBookTitlesByYearOfPublishing(@RequestParam(value = "year") Integer year) {
        return bookTitleMapper.mapToBookTitleDtoList(bookTitleService.getAllTitlesWithGivenPublishingYear(year));

    }

    @GetMapping(value = "/availableCopies")
    public List<BookCopyDto> fetchAllAvailableCopies() {
        return bookCopyMapper.mapToBookCopyDtoList(bookCopyService.getAllAvailableCopies());
    }
}
