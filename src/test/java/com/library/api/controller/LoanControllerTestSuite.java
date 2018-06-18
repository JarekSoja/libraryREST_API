package com.library.api.controller;

import com.google.gson.Gson;
import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.mapper.LoanMapper;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
import com.library.api.service.LoanService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@WebMvcTest(LoanController.class)
public class LoanControllerTestSuite {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanService loanService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private BookTitleRepository bookTitleRepository;

    @MockBean
    private LoanRepository loanRepository;

    @Autowired
    private LoanController loanController;

    @Test
    public void testCreateLoan() throws Exception {
        //Given
        User user1 = new User("John", "Smith");
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan = new Loan(user1, booksLoaned);
        when(bookTitleRepository.save(any(BookTitle.class))).thenReturn(bookTitle1);
        when(userRepository.save(any(User.class))).thenReturn(user1);
        when(loanRepository.save(any(Loan.class))).thenReturn(loan);

        //When&Then
        Gson gson = new Gson();
        String jsonContent = gson.toJson(loan);
        mockMvc.perform(post("/loans/new")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.loanId", is(1L)));



    }

}
