package com.library.api.dto;

import java.time.LocalDate;
import java.util.List;


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

    public LoanDto(long loanId, UserDto userDto, List<BookCopyDto> copiesDtoLoaned, LocalDate dateOfLoan, LocalDate dateOfReturn) {
        this.loanId = loanId;
        this.userDto = userDto;
        this.copiesDtoLoaned = copiesDtoLoaned;
        this.dateOfLoan = dateOfLoan;
        this.dateOfReturn = dateOfReturn;
    }

    public LoanDto() {
    }

    public long getLoanId() {
        return loanId;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public List<BookCopyDto> getCopiesDtoLoaned() {
        return copiesDtoLoaned;
    }

    public LocalDate getDateOfLoan() {
        return dateOfLoan;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }
}
