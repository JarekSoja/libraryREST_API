package com.library.rest_api.controller;

import com.library.rest_api.domain.Loan;
import com.library.rest_api.dto.LoanDto;
import com.library.rest_api.mapper.LoanMapper;
import com.library.rest_api.repository.LoanRepository;
import com.library.rest_api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/loans")
@RestController
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    LoanMapper loanMapper;

    @PostMapping
    Loan loan(@RequestBody LoanDto loanDto) {
        return null;
    }

    @PutMapping(value = "/{id}")
    LoanDto returnLoan(@PathVariable ("id") Long loanId, @RequestBody LoanDto loanDto) {
        return null;
    }

    @GetMapping
    List<LoanDto> fetchAllOverdueLoans() {
        return null;
    }

}
