package com.library.api.controller;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.dto.BookCopyDto;
import com.library.api.dto.BookTitleDto;
import com.library.api.mapper.BookCopyMapper;
import com.library.api.mapper.BookTitleMapper;
import com.library.api.service.BookCopyService;
import com.library.api.service.BookTitleService;
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
        List<BookTitle> allBookTitles = bookTitleService.getAllBookTitles();
        List<BookTitleDto> allBookTitlesDto = bookTitleMapper.mapToBookTitleDtoList(allBookTitles);
        return allBookTitlesDto;
    }

    @GetMapping(value = "/{id}")
    public BookTitleDto getBookTitleDetailId(@PathVariable("id") Long bookTitleId) {
        BookTitle searchedBookTitle = bookTitleService.getBookTitleById(bookTitleId);
        BookTitleDto bookToReturn = bookTitleMapper.mapToBookTitleDto(searchedBookTitle);
        return bookToReturn;
    }

    @PostMapping
    public BookTitle createBookTitle(@RequestBody BookTitleDto bookTitleDto) {
        BookTitle newTitle = bookTitleMapper.mapToBookTitle(bookTitleDto);
        return bookTitleService.saveBookTitle(newTitle);
    }

    @DeleteMapping(value = "/{id}")
    public void removeBookTitle(@PathVariable("id") Long bookTitleId) {
        bookTitleService.deleteBooktitle(bookTitleId);
    }

    @PutMapping
    public BookTitleDto updateBookTitle(@RequestBody BookTitleDto bookTitleDto) {
        BookTitle titleToUpdate = bookTitleMapper.mapToBookTitle(bookTitleDto);
        bookTitleService.saveBookTitle(titleToUpdate);
        BookTitleDto titleToReturn = bookTitleMapper.mapToBookTitleDto(titleToUpdate);
        return titleToReturn;
    }

    @GetMapping(value = "/search")
    public List<BookTitleDto> findBookTitles(@RequestParam(value = "author", required = false) String author,
                                             @RequestParam(value = "title", required = false) String title) {
        List<BookTitleDto> result = new ArrayList<>();
        if (author == null && title == null) {
            return result;
        } else if (!(author == null)) {
            List<BookTitle> searchResultByAuthor = bookTitleService.getBookTitleWithAuthor(author);
            result.addAll(bookTitleMapper.mapToBookTitleDtoList(searchResultByAuthor));
            if (!(title == null)) {
                List<BookTitle> searchResultByTitle = bookTitleService.getBookTitleWithAuthor(title);
                result.addAll(bookTitleMapper.mapToBookTitleDtoList(searchResultByTitle));
            }
        }
        return result;
    }

    @GetMapping(value = "/available")
    public List<BookTitleDto> retrieveBookTitlesWithAvailableCopies() {
        List<BookTitle> searchedTitles = bookTitleService.getAllTitlesWithAvailableCopies();
        return bookTitleMapper.mapToBookTitleDtoList(searchedTitles);
    }

    @GetMapping(value = "/copies/{copyId}")
    public BookCopyDto getBookCopyDetailId(@PathVariable("copyId") Long bookCopyId) {
        BookCopy bookCopy = bookCopyService.getBookCopyById(bookCopyId);
        BookCopyDto bookCopyDto = bookCopyMapper.mapToBookCopyDto(bookCopy);
        return bookCopyDto;
    }

    @GetMapping(value = "/copies")
    public List<BookCopyDto> getAllBookCopiesByTitle(@PathVariable("title") BookTitle bookTitle) {
        List<BookCopy> searchedBookCopies = bookCopyService.getAllCopiesOfTitle(bookTitle);
        return bookCopyMapper.mapToBookCopyDtoList(searchedBookCopies);
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

    @GetMapping(value = "/availableCopies/{boolean}")
    public List<BookCopyDto> getAllByAvailable(@RequestParam (value = "boolean") boolean param) {
        return bookCopyMapper.mapToBookCopyDtoList(bookCopyService.getAllByAvailable(param));
    }
}
