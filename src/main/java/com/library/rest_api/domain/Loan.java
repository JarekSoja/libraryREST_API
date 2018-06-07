package com.library.rest_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
@NamedNativeQuery(
        name = "Loan.fetchAllOverdueLoans",
        query = "SELECT * FROM LOANS\n " +
                "JOIN BOOK_COPIES ON LOAN_ID = LOANS.LOAN_COPIES\n " +
                "AND  LOAN.DATE_OF_RETURN < CURRENT_DATE()",
        resultClass = Loan.class
)

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "LOANS")
public class Loan {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "LOAN_ID", unique = true)
    private long loanId;

    @ManyToOne
    @JoinColumn (name = "LOANING_USER_ID")
    private User user;

    @OneToMany(
            targetEntity = BookCopy.class,
            mappedBy = "loan",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<BookCopy> copiesLoaned;

    @Column (name = "DATE_OF_LOAN")
    private LocalDate dateOfLoan;

    @Column (name = "DATE_OF_RETURN")
    private LocalDate dateOfReturn;

}
