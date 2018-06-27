package com.library.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class UserDto {

    @JsonProperty("userId")
    private long userId;

    @JsonProperty("userFirstName")
    private String userFirstName;

    @JsonProperty("userLastName")
    private String userLastName;

    @JsonProperty("dateOfCreation")
    private LocalDate dateOfCreation;

    @JsonProperty("listOfLoans")
    private List<LoanDto> listOfLoans;

    public UserDto(String userFirstName, String userLastName) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.listOfLoans = new ArrayList<>();
    }

    public UserDto(long userId, String userFirstName, String userLastName, LocalDate dateOfCreation, List<LoanDto> listOfLoans) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.dateOfCreation = dateOfCreation;
        this.listOfLoans = listOfLoans;
    }

    public UserDto(){
    }

    public long getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public LocalDate getDateOfCreation() {
        return dateOfCreation;
    }

    public List<LoanDto> getListOfLoans() {
        return listOfLoans;
    }
}
