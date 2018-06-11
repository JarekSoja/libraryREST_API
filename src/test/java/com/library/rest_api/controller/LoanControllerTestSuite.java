package com.library.rest_api.controller;

import com.library.rest_api.domain.BookCopy;
import com.library.rest_api.domain.BookTitle;
import com.library.rest_api.domain.Loan;
import com.library.rest_api.domain.User;
import com.library.rest_api.repository.BookCopyRepository;
import com.library.rest_api.repository.BookTitleRepository;
import com.library.rest_api.repository.LoanRepository;
import com.library.rest_api.repository.UserRepository;
import com.library.rest_api.service.LoanService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoanControllerTestSuite {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanService loanService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookTitleRepository bookTitleRepository;

    @Autowired
    BookCopyRepository bookCopyRepository;

    @Test
    public void testCreateLoan() {
        //Given
        User user1 = new User("John", "Smith");
        userRepository.save(user1);
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        //When
        Loan loan = new Loan(userRepository.getUserByUserId(1L), booksLoaned);
        loanRepository.save(loan);
        int numberOfLoansInDatabase = loanRepository.findAll().size();
        //Then
        Assert.assertEquals(1, numberOfLoansInDatabase);
    }

    @Test
    public void testReturnLoan() {
        //Given
        User user1 = new User("John", "Smith");
        userRepository.save(user1);
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan = new Loan(user1, booksLoaned);
        loanRepository.save(loan);
        //When
        loanService.returnLoan(loan);
        //Then
        Assert.assertEquals(bookCopy1.isAvailable(), true);
        Assert.assertEquals(bookCopy2.isAvailable(), true);
        //Cleanup
    }

    @Test
    public void testFetchOverdueLoans() {
        //Given
        User user1 = new User("John", "Smith");
        userRepository.save(user1);
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
        bookTitleRepository.save(bookTitle2);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        BookCopy bookCopy3 = new BookCopy(bookTitle2);
        BookCopy bookCopy4 = new BookCopy(bookTitle2);
        List<BookCopy> booksLoaned2 = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        booksLoaned2.add(bookCopy3);
        booksLoaned2.add(bookCopy4);
        Loan loan = new Loan(user1, booksLoaned);
        loanRepository.save(loan);
        Loan loan2 = new Loan(user1, booksLoaned2);
        loanRepository.save(loan2);
        loanService.returnLoan(loan);
        //When
        int numberOfOverdueLoans = loanRepository.fetchAllOverdueLoans().size();
        //Then
        Assert.assertEquals(0, numberOfOverdueLoans);
    }
}
