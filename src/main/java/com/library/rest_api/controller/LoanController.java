package com.library.rest_api.controller;

import com.library.rest_api.domain.NewLoan;
import com.library.rest_api.dto.LoanDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/loans")
@RestController
public class LoanController {

    @RequestMapping(method = RequestMethod.POST)
    NewLoan newLoan(@RequestBody LoanDto loanDto) {
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    LoanDto returnLoan(@PathVariable ("id") Long loanId, @RequestBody LoanDto loanDto) {
        return null;
    }

}
