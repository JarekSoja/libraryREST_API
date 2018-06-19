package com.library.api.dto;

import com.library.api.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookCopyDto {

    private long bookCopyId;
    private LoanDto loanDto;
    private BookTitleDto bookTitleDto;
    private boolean isAvailable;
}
