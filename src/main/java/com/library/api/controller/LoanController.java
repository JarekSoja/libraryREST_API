package com.library.api.controller;

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

    @Autowired
    public LoanService loanService;

    @Autowired
    public LoanMapper loanMapper;

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
