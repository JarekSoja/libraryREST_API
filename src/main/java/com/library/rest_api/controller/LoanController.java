package com.library.rest_api.controller;

import com.library.rest_api.dto.LoanDto;
import com.library.rest_api.mapper.LoanMapper;
import com.library.rest_api.service.LoanService;
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
        return loanMapper.mapToLoanDto(loanService.saveLoan(loanMapper.mapToLoan(loanDto)));
    }

    @GetMapping
    public List<LoanDto> fetchAllOverdueLoans() {
        return loanMapper.mapToLoanDtoList(loanService.getAllOverdueLoans());
    }

}
