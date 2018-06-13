package com.library.api.repository;

import com.library.api.domain.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    void deleteById(Long loanId);

    @Query(nativeQuery = true)
    List<Loan> fetchAllOverdueLoans();

    @Override
    List<Loan> findAll();
}
