package com.library.rest_api.controller;

import com.library.rest_api.domain.BookCopyDto;
import com.library.rest_api.domain.BookTitleDto;
import com.library.rest_api.domain.NewBookCopy;
import com.library.rest_api.domain.NewBookTitle;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/book")
public interface BookServiceInterface {

    @RequestMapping(method = RequestMethod.GET, value = "getAllBookTitles")
    List<BookTitleDto> getAllBookTitles();

    @RequestMapping(method = RequestMethod.GET, value = "getBookTitle")
    BookTitleDto getBookTitle(@RequestParam Long bookTitleId);

    @RequestMapping(method = RequestMethod.POST, value = "newBookTitle")
    NewBookTitle newBookTitle(@RequestBody BookTitleDto bookTitleDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "removeBookTitle")
    void removeBookTitle(@RequestParam Long bookTitleId);

    @RequestMapping(method = RequestMethod.PUT, value = "updateBookTitle")
    BookTitleDto updateBookTitle (@RequestBody BookTitleDto bookTitleDto);

    @RequestMapping(method = RequestMethod.POST, value = "newBookCopy")
    NewBookCopy newBookCopy(@RequestBody BookCopyDto bookCopyDto);

    @RequestMapping(method = RequestMethod.GET, value = "getAllBookCopies")
    List<BookCopyDto> getAllBookCopies();

    @RequestMapping(method = RequestMethod.GET, value = "getBookCopy")
    BookCopyDto getBookCopy(@RequestParam Long bookCopyId);

    @RequestMapping(method = RequestMethod.GET, value = "getBookCopiesByAuthor")
    List<BookCopyDto> getBookCopiesByAuthor(@RequestParam String author);

    @RequestMapping(method = RequestMethod.GET, value = "getBookCopiesByTitle")
    List<BookCopyDto> getBookCopiesByTitle(@RequestParam String title);

    @RequestMapping(method = RequestMethod.DELETE, value = "removeBookCopy")
    void removeBookCopy(@RequestParam Long bookCopyId);

    @RequestMapping(method = RequestMethod.PUT, value = "updateBookCopy")
    BookCopyDto updateBooCopy (@RequestBody BookCopyDto bookCopyDto);

}
