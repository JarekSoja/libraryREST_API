package com.library.api.domain;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public User(String userFirstName, String userLastName, LocalDate dateOfCreation, List<Loan> listOfLoans) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.dateOfCreation = dateOfCreation;
        this.listOfLoans = listOfLoans;
    }

    public User(Long userId, String userFirstName, String userLastName, LocalDate dateOfCreation, List<Loan> listOfLoans) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.dateOfCreation = dateOfCreation;
        this.listOfLoans = listOfLoans;
    }

    public User() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public List<Loan> getListOfLoans() {
        return listOfLoans;
    }

    public void setListOfLoans(List<Loan> listOfLoans) {
        this.listOfLoans = listOfLoans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUserId() == user.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}
