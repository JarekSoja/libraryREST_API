package com.library.rest_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@NamedNativeQuery(
        name = "User.retrieveUsersWithOverdueLoans",
        query = "SELECT * FROM USERS\n " +
                "JOIN LOANS ON USER_ID = LOANS.LOAN_COPIES\n " +
                "AND  LOAN.DATE_OF_RETURN < CURRENT_DATE()",
        resultClass = User.class
)
@NamedQuery(
        name = "User.retrieveUsersWithNameContaining",
        query = "FROM User WHERE userLastName LIKE CONCAT('%',:GIVEN_STRING,'%')"
)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private long userId;

    @Column(name = "USER_FIRST_NAME")
    private String userFirstName;

    @Column(name = "USER_LAST_NAME")
    private String userLastName;

    @Column(name = "DATE_OF_ACCOUNT_CREATION", updatable=false)
    @CreationTimestamp
    private LocalDate dateOfCreation;

    @OneToMany(
            targetEntity = Loan.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<Loan> listOfLoans;

}
