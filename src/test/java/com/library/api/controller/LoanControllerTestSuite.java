package com.library.api.controller;

import com.google.gson.Gson;
import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.dto.BookCopyDto;
import com.library.api.dto.LoanDto;
import com.library.api.dto.UserDto;
import com.library.api.mapper.LoanMapper;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.ArgumentMatchers.any;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class LoanControllerTestSuite {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookTitleRepository bookTitleRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private LoanRepository loanRepository;
    @MockBean
    private LoanMapper loanMapper;
    @MockBean
    private BookCopyRepository bookCopyRepository;


    @Test
    public void testCreateLoan() throws Exception {
        //Given
        User user1 = new User("John", "Smith");
        UserDto userDto1 = new UserDto("John", "Smith");
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        List<BookCopyDto> listDto = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan = new Loan(user1, booksLoaned);
        LoanDto loanDto = new LoanDto(userDto1, listDto);
        when(bookTitleRepository.save(any(BookTitle.class))).thenReturn(bookTitle1);
        when(userRepository.save(any(User.class))).thenReturn(user1);
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);
        when(loanMapper.mapToLoan(any(LoanDto.class))).thenReturn(loan);
        when(loanMapper.mapToLoanDto(any(Loan.class))).thenReturn(loanDto);

        //When&Then
        Gson gson = new Gson();
        String jsonContent = gson.toJson(loan);
        mockMvc.perform(post("/loans")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.userDto.userLastName", is("Smith")));
    }

    @Test
    public void testFetchAllOverdueLoans() throws Exception {
        //Given
        User user1 = new User("John", "Smith");
        UserDto userDto1 = new UserDto("John", "Smith");
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        List<BookCopyDto> listDto = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan = new Loan(user1, booksLoaned);
        LoanDto loanDto = new LoanDto(userDto1, listDto);
        when(bookTitleRepository.save(any(BookTitle.class))).thenReturn(bookTitle1);
        when(userRepository.save(any(User.class))).thenReturn(user1);
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);
        when(loanMapper.mapToLoan(any(LoanDto.class))).thenReturn(loan);
        when(loanMapper.mapToLoanDto(any(Loan.class))).thenReturn(loanDto);

        //When&&Then
        mockMvc.perform(get("/loans").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$", hasSize(0)));


    }

}
