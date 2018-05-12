package com.library.rest_api.controller;

import com.library.rest_api.domain.NewLoan;
import com.library.rest_api.Dto.LoanDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/loans")
public interface LoanControllerInterface {

    @RequestMapping(method = RequestMethod.POST)
    NewLoan newLoan(@RequestBody LoanDto loanDto);

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    LoanDto returnLoan(@PathVariable ("id") Long loanId, @RequestBody LoanDto loanDto);

}
