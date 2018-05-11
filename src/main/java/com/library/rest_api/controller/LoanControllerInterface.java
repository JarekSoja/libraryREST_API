package com.library.rest_api.controller;

import com.library.rest_api.domain.NewLoan;
import com.library.rest_api.domain.LoanDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/loan")
public interface LoanControllerInterface {

    @RequestMapping(method = RequestMethod.POST, value = "newLoan")
    NewLoan newLoan(@RequestBody LoanDto loanDto);

    @RequestMapping(method = RequestMethod.PUT, value = "returnLoan")
    LoanDto returnLoan(@RequestBody LoanDto loanDto);

}
