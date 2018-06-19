package com.library.api.mapper;

import com.library.api.domain.BookTitle;
import com.library.api.dto.BookTitleDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTitleMapper {

    public BookTitleDto mapToBookTitleDto(BookTitle bookTitle) {
        return new BookTitleDto(bookTitle.getBookTitleId(),
                bookTitle.getListOfCopies(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getYearOfPublishing()
        );
    }

    public BookTitle mapToBookTitle(BookTitleDto bookTitleDto) {
        return new BookTitle(bookTitleDto.getBookTitleId(),
                bookTitleDto.getListOfCopies(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getYearOfPublishing()
        );
    }

    public List<BookTitleDto> mapToBookTitleDtoList(List<BookTitle> bookTitles) {
        return bookTitles.stream()
                .map(b -> new BookTitleDto(b.getBookTitleId(),
                        b.getListOfCopies(),
                        b.getTitle(),
                        b.getAuthor(),
                        b.getYearOfPublishing()))
                .collect(Collectors.toList());
    }
}