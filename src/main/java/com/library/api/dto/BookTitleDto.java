package com.library.api.dto;

import com.library.api.domain.BookCopy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookTitleDto {

    private long bookTitleId;
    private List<BookCopy> listOfCopies;
    private String title;
    private String author;
    private int yearOfPublishing;

}
