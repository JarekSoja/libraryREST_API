package com.library.rest_api.controller;

import com.library.rest_api.Dto.BookCopyDto;
import com.library.rest_api.Dto.BookTitleDto;
import com.library.rest_api.domain.NewBookCopy;
import com.library.rest_api.domain.NewBookTitle;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/books")
public interface BookServiceInterface {

    @RequestMapping(method = RequestMethod.GET)
    List<BookTitleDto> getAllBookTitles();

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    BookTitleDto getBookTitleDetaild(@PathVariable("id") Long bookTitleId);

    @RequestMapping(method = RequestMethod.POST)
    NewBookTitle newBookTitle(@RequestBody BookTitleDto bookTitleDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    void removeBookTitle(@PathVariable("id") Long bookTitleId);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    BookTitleDto updateBookTitle(@PathVariable("id") Long bookCopyId, @RequestBody BookTitleDto bookTitleDto);

    @RequestMapping(method = RequestMethod.GET, value = "/search")
    List<BookTitleDto> findBookTitles(@RequestParam(value = "author", required = false) String author,
                                      @RequestParam(value = "title", required = false) String title);

    //TODO Search all titles with available copies

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/copies")
    List<BookCopyDto> getAllBookCopies(@PathVariable("id") Long bookTitleId);

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/copies/{copyId}")
    BookTitleDto getBookTitleDetaild(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId);

    @RequestMapping(method = RequestMethod.POST)
    NewBookCopy newBookCopy(@RequestBody BookCopyDto bookCopyDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}/copies/{copyId}")
    void removeBookTitle(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/copies/{copyId}")
    BookTitleDto updateBookTitle(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId);

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    List<BookTitleDto> findBookTitles(@PathVariable("id") Long bookTitleId,
                                      @RequestParam(value = "year", required = false) Integer yearOfPublishing,
                                      @RequestParam(value = "isAvailabe", required = false) boolean isAvailable);

    //TODO Return total number of particular title copies divided to available and unavailable.

    //TODO Return all available copies, regardless of title.

    //TODO Return all overdue copies.


}
