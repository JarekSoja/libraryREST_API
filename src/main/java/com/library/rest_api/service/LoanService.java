package com.library.rest_api.service;

import com.library.rest_api.domain.Loan;
import com.library.rest_api.repository.LoanRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;


    void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    List<Loan> getAllOverdueLoans() {
       return loanRepository.fetchAllOverdueLoans ();
    }
}
