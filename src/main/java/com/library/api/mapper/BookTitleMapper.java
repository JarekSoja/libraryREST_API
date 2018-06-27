package com.library.api.mapper;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.dto.BookTitleDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookTitleMapper {

    public BookTitleDto mapToBookTitleDto(BookTitle bookTitle) {
        BookTitleDto bookToReturn = new BookTitleDto(bookTitle.getBookTitleId(),
                bookTitle.getTitle(),
                bookTitle.getAuthor(),
                bookTitle.getYearOfPublishing()
        );

        bookToReturn.setListOfCopies(bookTitle.getListOfCopies());

        return bookToReturn;
    }

    public BookTitle mapToBookTitle(BookTitleDto bookTitleDto) {
        BookTitle titleToReturn =  new BookTitle(bookTitleDto.getBookTitleId(),
                bookTitleDto.getTitle(),
                bookTitleDto.getAuthor(),
                bookTitleDto.getYearOfPublishing()
        );

        titleToReturn.setListOfCopies(bookTitleDto.getListOfCopies());

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

            List<BookCopy> listOfCopies = t.getListOfCopies();

            listToReturn.get(listToReturn.size()-1).setListOfCopies(listOfCopies);
        }
        return listToReturn;
    }
}