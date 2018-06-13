package com.library.api.mapper;

import com.library.api.domain.Loan;
import com.library.api.dto.LoanDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanMapper {

    public Loan mapToLoan(final LoanDto loanDto) {

        return new Loan(loanDto.getLoanId(),
                loanDto.getUser(),
                loanDto.getCopiesLoaned(),
                loanDto.getDateOfLoan(),
                loanDto.getDateOfReturn()
        );
    }

    public LoanDto mapToLoanDto(final Loan loan) {

        return new LoanDto(loan.getLoanId(),
                loan.getUser(),
                loan.getCopiesLoaned(),
                loan.getDateOfLoan(),
                loan.getDateOfReturn()
        );
    }

    public List<Loan> mapToLoanList(final List<LoanDto> loanDtoList) {
        return loanDtoList.stream()
                .map(l -> new Loan(l.getLoanId(),
                        l.getUser(),
                        l.getCopiesLoaned(),
                        l.getDateOfLoan(),
                        l.getDateOfReturn()))
                .collect(Collectors.toList());
    }

    public List<LoanDto> mapToLoanDtoList(final List<Loan> loanList) {
        return loanList.stream()
                .map(l -> new LoanDto(l.getLoanId(),
                        l.getUser(),
                        l.getCopiesLoaned(),
                        l.getDateOfLoan(),
                        l.getDateOfReturn()))
                .collect(Collectors.toList());
    }
}
