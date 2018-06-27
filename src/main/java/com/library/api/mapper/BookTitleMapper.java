package com.library.api.mapper;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.dto.BookCopyDto;
import com.library.api.dto.BookTitleDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookTitleMapper {

    public BookTitleDto mapToBookTitleDto(BookTitle bookTitle) {
        BookCopyMapper bookCopyMapper = new BookCopyMapper();
        BookTitleDto bookToReturn = new BookTitleDto(bookTitle.getBookTitleId(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getYearOfPublishing()
        );

        List<BookCopyDto> listOfCopies = bookTitle.getListOfCopies().stream()
                .map(c -> bookCopyMapper.mapToBookCopyDto(c))
                .collect(Collectors.toList());

        bookToReturn.setListOfCopies(listOfCopies);

        return bookToReturn;
    }

    public BookTitle mapToBookTitle(BookTitleDto bookTitleDto) {
        BookCopyMapper bookCopyMapper = new BookCopyMapper();
        BookTitle titleToReturn =  new BookTitle(bookTitleDto.getBookTitleId(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getYearOfPublishing()
        );
        List<BookCopy> listOfCopies = bookTitleDto.getListOfCopies().stream()
                .map(c -> bookCopyMapper.mapToBookCopy(c))
                .collect(Collectors.toList());

        titleToReturn.setListOfCopies(listOfCopies);

        return titleToReturn;
    }

    public List<BookTitleDto> mapToBookTitleDtoList(List<BookTitle> bookTitles) {
        BookCopyMapper bookCopyMapper = new BookCopyMapper();
        List<BookTitleDto> listToReturn = new ArrayList<>();

        for (BookTitle t : bookTitles) {
            listToReturn.add(new BookTitleDto(t.getBookTitleId(),
                    t.getTitle(),
                    t.getAuthor(),
                    t.getYearOfPublishing()
            ));
            List<BookCopyDto> listOfCopies = bookCopyMapper.mapToBookCopyDtoList(t.getListOfCopies());

            listToReturn.get(listToReturn.size()).setListOfCopies(listOfCopies);
        }
        return listToReturn;
    }
}