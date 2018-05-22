package com.library.rest_api.dto;

import com.library.rest_api.domain.BookTitle;
import com.library.rest_api.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookCopyDto {

    private long bookCopyId;
    private Loan loan;
    private BookTitle bookTitle;
    private boolean isAvailable;
}
