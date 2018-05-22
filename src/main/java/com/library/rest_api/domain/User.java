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
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "USER_ID", unique = true)
    private long userId;

    @Column (name = "USER_FIRST_NAME")
    private String userFirstName;

    @Column (name = "USER_LAST_NAME")
    private String userLastName;

    @Column (name = "DATE_OF_ACCOUNT_CREATION")
    private LocalDate dateOfCreation;

    @OneToMany(
            targetEntity = Loan.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<Loan> listOfLoans;


}
