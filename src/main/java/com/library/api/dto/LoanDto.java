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

    private long loanId;
    private UserDto userDto;
    private List<BookCopyDto> copiesDtoLoaned;
    private LocalDate dateOfLoan;
    private LocalDate dateOfReturn;

    public LoanDto(UserDto user, List<BookCopyDto> copiesLoaned) {
        this.userDto = user;
        this.copiesDtoLoaned = copiesLoaned;
    }
}
