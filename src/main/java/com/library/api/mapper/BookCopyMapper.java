package com.library.api.mapper;


import com.library.api.domain.BookCopy;
import com.library.api.dto.BookCopyDto;
import com.library.api.dto.BookTitleDto;
import com.library.api.dto.LoanDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookCopyMapper {

    public BookCopyDto mapToBookCopyDto(BookCopy bookCopy) {
        LoanMapper loanMapper = new LoanMapper();
        BookTitleMapper bookTitleMapper = new BookTitleMapper();
        return new BookCopyDto(bookCopy.getBookCopyId(),
                loanMapper.mapToLoanDto(bookCopy.getLoan()),
                bookTitleMapper.mapToBookTitleDto(bookCopy.getBookTitle()),
                bookCopy.isAvailable()
        );
    }

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto) {
        LoanMapper loanMapper = new LoanMapper();
        BookTitleMapper bookTitleMapper = new BookTitleMapper();
        return new BookCopy(bookCopyDto.getBookCopyId(),
                loanMapper.mapToLoan(bookCopyDto.getLoanDto()),
                bookTitleMapper.mapToBookTitle(bookCopyDto.getBookTitleDto()),
                bookCopyDto.isAvailable()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList(List<BookCopy> bookCopies) {
        LoanMapper loanMapper = new LoanMapper();
        BookTitleMapper bookTitleMapper = new BookTitleMapper();
        return bookCopies.stream()
                .map(bookCopy -> new BookCopyDto(bookCopy.getBookCopyId(),
                        loanMapper.mapToLoanDto(bookCopy.getLoan()),
                        bookTitleMapper.mapToBookTitleDto(bookCopy.getBookTitle()),
                        bookCopy.isAvailable()))
                .collect(Collectors.toList());
    }

    public List<BookCopy> mapToBookCopyList(List<BookCopyDto> bookCopiesDto) {
        LoanMapper loanMapper = new LoanMapper();
        BookTitleMapper bookTitleMapper = new BookTitleMapper();
        return bookCopiesDto.stream()
                .map(bookCopyDto -> new BookCopy(bookCopyDto.getBookCopyId(),
                        loanMapper.mapToLoan(bookCopyDto.getLoanDto()),
                        bookTitleMapper.mapToBookTitle(bookCopyDto.getBookTitleDto()),
                        bookCopyDto.isAvailable()))
                .collect(Collectors.toList());
    }
}
