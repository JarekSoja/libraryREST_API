package com.library.rest_api.dto;

import com.library.rest_api.domain.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {

    private long userId;
    private String userFirstName;
    private String userLastName;
    private LocalDate dateOfCreation;
    private List<Loan> listOfLoans;

}
