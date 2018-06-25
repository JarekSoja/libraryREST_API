package com.library.api.controller;

import com.library.api.domain.Loan;
import com.library.api.dto.LoanDto;
import com.library.api.mapper.LoanMapper;
import com.library.api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/loans")
@RestController
public class LoanController {

    private final LoanService loanService;

    private final LoanMapper loanMapper;

    @Autowired
    public LoanController(LoanService loanService, LoanMapper loanMapper) {
        this.loanService = loanService;
        this.loanMapper = loanMapper;
    }

    @PostMapping
    public LoanDto createLoan(@RequestBody LoanDto loanDto) {
        Loan loanToSave = loanMapper.mapToLoan(loanDto);
        Loan loanSaved = loanService.saveLoan(loanToSave);
        LoanDto result = loanMapper.mapToLoanDto(loanSaved);
        return result;
    }

    @PutMapping
    public LoanDto returnLoan(@RequestBody LoanDto loanDto) {
        Loan loanToSave = loanMapper.mapToLoan(loanDto);
        Loan loanReturned = loanService.returnLoan(loanToSave);
        LoanDto result = loanMapper.mapToLoanDto(loanReturned);
        return result;
    }

    @GetMapping
    public List<LoanDto> fetchAllOverdueLoans() {
        List<Loan> overdueLoans = loanService.getAllOverdueLoans();
        List<LoanDto> overdueLoansDto = loanMapper.mapToLoanDtoList(overdueLoans);
        return overdueLoansDto;
    }

}
