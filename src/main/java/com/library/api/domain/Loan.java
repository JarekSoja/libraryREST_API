package com.library.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
@NamedNativeQuery(
        name = "Loan.fetchAllOverdueLoans",
        query = "SELECT * FROM LOANS WHERE  DATE_OF_RETURN < CURRENT_DATE()",
        resultClass = Loan.class
)

@Entity
@Table(name = "LOANS")
public class Loan {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "LOAN_ID", unique = true)
    private long loanId;

    @ManyToOne
    @JsonIgnore
    @JoinColumn (name = "LOANING_USER_ID")
    private User user;

    @OneToMany(
            targetEntity = BookCopy.class,
            mappedBy = "loan",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<BookCopy> copiesLoaned;

    @Column (name = "DATE_OF_LOAN", updatable = false)
    @CreationTimestamp
    private LocalDate dateOfLoan;

    @Column (name = "DATE_OF_RETURN", updatable = false)
    private LocalDate dateOfReturn;

    public Loan(User user, List<BookCopy> copiesLoaned) {
        this.user = user;
        this.copiesLoaned = copiesLoaned;
    }

    public Loan(long id, User user, List<BookCopy> copiesLoaned, LocalDate dateOfLoan, LocalDate dateOfReturn) {
        this.loanId = loanId;
        this.user = user;
        this.copiesLoaned = copiesLoaned;
        this.dateOfLoan = dateOfLoan;
        this.dateOfReturn = dateOfReturn;
    }

    public Loan() {
    }

    public long getLoanId() {
        return loanId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BookCopy> getCopiesLoaned() {
        return copiesLoaned;
    }

    public void setCopiesLoaned(List<BookCopy> copiesLoaned) {
        this.copiesLoaned = copiesLoaned;
    }

    public LocalDate getDateOfLoan() {
        return dateOfLoan;
    }

    public void setDateOfLoan(LocalDate dateOfLoan) {
        this.dateOfLoan = dateOfLoan;
    }

    public LocalDate getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(LocalDate dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
