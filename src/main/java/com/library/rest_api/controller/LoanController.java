package com.library.rest_api.controller;

import com.library.rest_api.domain.Loan;
import com.library.rest_api.dto.LoanDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/loans")
@RestController
public class LoanController {

    @PostMapping
    Loan loan(@RequestBody LoanDto loanDto) {
        return null;
    }

    @PutMapping(value = "/{id}")
    LoanDto returnLoan(@PathVariable ("id") Long loanId, @RequestBody LoanDto loanDto) {
        return null;
    }

}
