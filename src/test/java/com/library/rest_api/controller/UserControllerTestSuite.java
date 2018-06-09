package com.library.rest_api.controller;

import com.library.rest_api.domain.BookCopy;
import com.library.rest_api.domain.BookTitle;
import com.library.rest_api.domain.Loan;
import com.library.rest_api.domain.User;
import com.library.rest_api.dto.UserDto;
import com.library.rest_api.repository.BookCopyRepository;
import com.library.rest_api.repository.BookTitleRepository;
import com.library.rest_api.repository.LoanRepository;
import com.library.rest_api.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTestSuite {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookTitleRepository bookTitleRepository;

    @Autowired
    BookCopyRepository bookCopyRepository;

    @Before
    public void createTestData() {
        User user1 = new User("John", "Smith");
        User user2 = new User("Mark", "Woytkovitz");
        User user3 = new User("Joanna", "Zemla");
        User user4 = new User("Mary", "Booyko");
        User user5 = new User("Xanadu", "Paradise");
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
        BookTitle bookTitle3 = new BookTitle("Coun", "Hooppp", 1988);
        BookTitle bookTitle4 = new BookTitle("Dumbo", "Sfsdfsd", 1934);
        BookTitle bookTitle5 = new BookTitle("Edvard IV", "BBBBb", 1966);
        BookTitle bookTitle6 = new BookTitle("Father John", "Geaaaaa", 1981);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        BookCopy bookCopy3 = new BookCopy(bookTitle2);
        BookCopy bookCopy4 = new BookCopy(bookTitle2);
        BookCopy bookCopy5 = new BookCopy(bookTitle3);
        BookCopy bookCopy6 = new BookCopy(bookTitle3);
        BookCopy bookCopy7 = new BookCopy(bookTitle4);
        BookCopy bookCopy8 = new BookCopy(bookTitle4);
        BookCopy bookCopy9 = new BookCopy(bookTitle4);
        BookCopy bookCopy10 = new BookCopy(bookTitle5);
        BookCopy bookCopy11 = new BookCopy(bookTitle5);
        BookCopy bookCopy12 = new BookCopy(bookTitle6);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan1 = new Loan(user1, booksLoaned);
    }
//
//    @Test
//    public void test
//
//    @Test
//    public void test
//
//    @Test
//    public void test
//
//    @Test
//    public void test
//
//    @Test
//    public void test
//
//    @Test
//    public void test
//
//    @Test
//    public void test
//
//
//    public List<UserDto> getAllUsers() {
//    }
//
//    public UserDto getUser(@PathVariable("id") Long userId) {
//    }
//
//    public void createUser(@RequestBody UserDto userDto) {
//    }
//
//    public void removeUser(@PathVariable("id") Long userId) {
//    }
//
//    public UserDto updateUser(@PathVariable("id") Long userId, @RequestBody UserDto userDto) {
//    }
//
//    public List<UserDto> retrieveUsersWithNameContaining(@PathVariable("searchedString") String searchedString) {
//    }
//
//    public List<UserDto> retrieveUsersWithOverdueLoans() {
//    }
}
