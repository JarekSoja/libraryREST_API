package com.library.rest_api.repository;

import com.library.rest_api.domain.Loan;
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

}
