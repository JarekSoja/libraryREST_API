package com.library.api.mapper;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.dto.BookCopyDto;
import com.library.api.dto.BookTitleDto;
import com.library.api.dto.LoanDto;
import com.library.api.dto.UserDto;
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
public class LoanMapperTestSuite {

    @Autowired
    private LoanMapper loanMapper;



    @Test
    public void testMapToLoanDto() {
        //Given
        User user1 = new User("John", "Smith");
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan = new Loan(user1, booksLoaned);

        //When
        LoanDto loanDto = loanMapper.mapToLoanDto(loan);
        String testUserFirstName = loanDto.getUserDto().getUserFirstName();
        int testNumberOfCopies = loanDto.getCopiesDtoLoaned().size();

        //Then
        Assert.assertEquals("John", testUserFirstName);
        Assert.assertEquals(2, testNumberOfCopies);
    }

    @Test
    public void testMapToLoan() {
        //Given
        UserDto user1 = new UserDto("John", "Smith");
        BookTitleDto bookTitle1 = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        BookCopyDto bookCopy1 = new BookCopyDto(bookTitle1);
        BookCopyDto bookCopy2 = new BookCopyDto(bookTitle1);
        List<BookCopyDto> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        LoanDto loanDto = new LoanDto(user1, booksLoaned);

        //When
        Loan loan = loanMapper.mapToLoan(loanDto);
        String testUserFirstName = loan.getUser().getUserFirstName();
        int testNumberOfCopies = loan.getCopiesLoaned().size();

        //Then
        Assert.assertEquals("John", testUserFirstName);
        Assert.assertEquals(2, testNumberOfCopies);
    }

    @Test
    public void testMapToLoanDtoList() {
        //Given
        User user1 = new User("John", "Smith");
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan = new Loan(user1, booksLoaned);
        Loan loan2 = new Loan(user1, booksLoaned);
        List<Loan> loans = new ArrayList<>();
        loans.add(loan);
        loans.add(loan2);

        //When
        List<LoanDto> loansDto = loanMapper.mapToLoanDtoList(loans);
        String testUserFirstName = loansDto.get(0).getUserDto().getUserFirstName();
        int testNumberOfCopies = loansDto.get(1).getCopiesDtoLoaned().size();

        //Then
        Assert.assertEquals("John", testUserFirstName);
        Assert.assertEquals(2, testNumberOfCopies);
    }

    @Test
    public void testMapToLoanList() {
        //Given
        UserDto user1 = new UserDto("John", "Smith");
        BookTitleDto bookTitle1 = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        BookCopyDto bookCopy1 = new BookCopyDto(bookTitle1);
        BookCopyDto bookCopy2 = new BookCopyDto(bookTitle1);
        List<BookCopyDto> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        LoanDto loanDto = new LoanDto(user1, booksLoaned);
        LoanDto loanDto2 = new LoanDto(user1, booksLoaned);
        List<LoanDto> listDto = new ArrayList<>();
        listDto.add(loanDto);
        listDto.add(loanDto2);

        //When
        List<Loan> loans = loanMapper.mapToLoanList(listDto);
        String testUserFirstName = loans.get(0).getUser().getUserFirstName();
        int testNumberOfCopies = loans.get(1).getCopiesLoaned().size();

        //Then
        Assert.assertEquals("John", testUserFirstName);
        Assert.assertEquals(2, testNumberOfCopies);
    }
}
