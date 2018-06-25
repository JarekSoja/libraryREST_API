package com.library.api.service;

import com.library.api.domain.BookCopy;
import com.library.api.domain.Loan;
import com.library.api.repository.LoanRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class LoanService {

    @Autowired
    public LoanRepository loanRepository;

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> getAllOverdueLoans() {
       return loanRepository.fetchAllOverdueLoans ();
    }

    public Loan returnLoan(Loan loan) {
        for (BookCopy bc : loan.getCopiesLoaned()) {
            bc.setAvailable(true);
        }
        loan.getCopiesLoaned().clear();
        return loanRepository.save(loan);
    }

    public Loan saveLoan(Loan loan) {
        for (BookCopy bc : loan.getCopiesLoaned()) {
            bc.setAvailable(false);
        }
        return loanRepository.save(loan);
    }
}
