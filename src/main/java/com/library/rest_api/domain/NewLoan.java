package com.library.rest_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "LOANS")
class NewLoan {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "LOAN_ID", unique = true)
    private long newLoanId;

    @ManyToOne
    @JoinColumn (name = "LOANING_USER_ID")
    private NewUser newUser;

    @OneToMany(
            targetEntity = NewBookCopy.class,
            mappedBy = "newBookLoan",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<NewBookCopy> copiesLoaned;

    @Column (name = "DATE_OF_LOAN")
    private LocalDate dateOfLoan;

    @Column (name = "DATE_OF_RETURN")
    private LocalDate dateOfReturn;

}
