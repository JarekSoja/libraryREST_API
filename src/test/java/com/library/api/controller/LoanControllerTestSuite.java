package com.library.api.controller;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.dto.LoanDto;
import com.library.api.mapper.LoanMapper;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
import com.library.api.service.LoanService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanControllerTestSuite {

    @Autowired
    public LoanService loanService;

    @Autowired
    public LoanMapper loanMapper;

    @Test
    public void testCreateLoan() {

    }

    @PostMapping
    public void crateLoan(@RequestBody LoanDto loanDto) {
        loanService.saveLoan(loanMapper.mapToLoan(loanDto));
    }

    @PutMapping
    public LoanDto returnLoan(@RequestBody LoanDto loanDto) {
        return loanMapper.mapToLoanDto(loanService.returnLoan(loanMapper.mapToLoan(loanDto)));
    }

    @GetMapping
    public List<LoanDto> fetchAllOverdueLoans() {
        return loanMapper.mapToLoanDtoList(loanService.getAllOverdueLoans());
    }
}
