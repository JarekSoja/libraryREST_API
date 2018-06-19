package com.library.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.api.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
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
}
