package com.library.api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NamedNativeQuery(
        name = "User.retrieveUsersWithOverdueLoans",
        query = "SELECT USER_ID FROM USERS, LOANS " +
                "WHERE LOANS.DATE_OF_RETURN < CURRENT_DATE()",
        resultClass = User.class
)
@NamedQuery(
        name = "User.retrieveUsersWithNameContaining",
        query = "FROM User WHERE userLastName LIKE CONCAT ('%',:STRING,'%')"
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

    public User(String userFirstName, String userLastName) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.listOfLoans = new ArrayList<>();
    }
}
