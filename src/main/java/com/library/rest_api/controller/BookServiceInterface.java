package com.library.rest_api.controller;

import com.library.rest_api.domain.BookTitleDto;
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
}
