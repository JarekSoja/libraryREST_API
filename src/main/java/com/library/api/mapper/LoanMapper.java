package com.library.api.mapper;

import com.library.api.domain.Loan;
import com.library.api.dto.LoanDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanMapper {

    private UserMapper userMapper;

    private BookCopyMapper bookCopyMapper;

    public Loan mapToLoan(final LoanDto loanDto) {
        return new Loan(loanDto.getLoanId(),
                userMapper.maptoUser(loanDto.getUserDto()),
                bookCopyMapper.mapToBookCopyList(loanDto.getCopiesDtoLoaned()),
                loanDto.getDateOfLoan(),
                loanDto.getDateOfReturn()
        );
    }

    public com.library.api.dto.LoanDto mapToLoanDto(final Loan loan) {
        return new com.library.api.dto.LoanDto(loan.getLoanId(),
                userMapper.maptoUserDto(loan.getUser()),
                bookCopyMapper.mapToBookCopyDtoList(loan.getCopiesLoaned()),
                loan.getDateOfLoan(),
                loan.getDateOfReturn()
        );
    }

    public List<com.library.api.dto.LoanDto> mapToLoanDtoList(final List<Loan> loanList) {
        return loanList.stream()
                .map(l -> new com.library.api.dto.LoanDto(l.getLoanId(),
                        userMapper.maptoUserDto(l.getUser()),
                        bookCopyMapper.mapToBookCopyDtoList(l.getCopiesLoaned()),
                        l.getDateOfLoan(),
                        l.getDateOfReturn()))
                .collect(Collectors.toList());
    }

    public List<Loan> mapToLoanList(final List<LoanDto> loanList) {
        return loanList.stream()
                .map(l -> new Loan(l.getLoanId(),
                        userMapper.maptoUser(l.getUserDto()),
                        bookCopyMapper.mapToBookCopyList(l.getCopiesDtoLoaned()),
                        l.getDateOfLoan(),
                        l.getDateOfReturn()))
                .collect(Collectors.toList());
    }
}
