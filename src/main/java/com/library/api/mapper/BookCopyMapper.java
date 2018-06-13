package com.library.api.mapper;


import com.library.api.domain.BookCopy;
import com.library.api.dto.BookCopyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyMapper {

    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy) {
        return new BookCopyDto(bookCopy.getBookCopyId(),
                bookCopy.getLoan(),
                bookCopy.getBookTitle(),
                bookCopy.isAvailable()
        );
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto) {
        return new BookCopy(bookCopyDto.getBookCopyId(),
                bookCopyDto.getLoan(),
                bookCopyDto.getBookTitle(),
                bookCopyDto.isAvailable()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookCopies) {
        return bookCopies.stream()
                .map(bookCopy -> new BookCopyDto(bookCopy.getBookCopyId(),
                        bookCopy.getLoan(),
                        bookCopy.getBookTitle(),
                        bookCopy.isAvailable()))
                .collect(Collectors.toList());
    }

    public List<BookCopy> mapToBookCopyList(List<BookCopyDto> bookCopiesDto) {
        return bookCopiesDto.stream()
                .map(bookCopyDto -> new BookCopy(bookCopyDto.getBookCopyId(),
                        bookCopyDto.getLoan(),
                        bookCopyDto.getBookTitle(),
                        bookCopyDto.isAvailable()))
                .collect(Collectors.toList());
    }
}
