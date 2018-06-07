package com.library.rest_api.dto;

import com.library.rest_api.domain.User;
import com.library.rest_api.domain.BookCopy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoanDto {

    private long loanId;
    private User user;
    private List<BookCopy> copiesLoaned;
    private LocalDate dateOfLoan;
    private LocalDate dateOfReturn;
}
