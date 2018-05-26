package com.library.rest_api.repository;

import com.library.rest_api.domain.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface LoanRepository extends CrudRepository<Loan, Long> {

    void delete(Long loanId);

}
