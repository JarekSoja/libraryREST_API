package com.library.api.dto;

import com.library.api.domain.User;
import com.library.api.domain.BookCopy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoanDto {

    private long loanId = 1;
    private User user;
    //TODO change to UserDto
    private List<BookCopy> copiesLoaned;
    private LocalDate dateOfLoan;
    private LocalDate dateOfReturn;
}
