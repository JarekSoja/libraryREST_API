package com.library.rest_api.controller;

import com.library.rest_api.domain.BookCopy;
import com.library.rest_api.domain.BookTitle;
import com.library.rest_api.domain.Loan;
import com.library.rest_api.domain.User;
import com.library.rest_api.repository.BookCopyRepository;
import com.library.rest_api.repository.BookTitleRepository;
import com.library.rest_api.repository.LoanRepository;
import com.library.rest_api.repository.UserRepository;
import com.library.rest_api.service.UserService;
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
public class UserControllerTestSuite {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    BookTitleRepository bookTitleRepository;

    @Autowired
    BookCopyRepository bookCopyRepository;

    @Test
    public void testGetAllUsers() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Smith"));
        users.add(new User("Mark", "Woytkovitz"));
        users.add(new User("Joanna", "Zemla"));
        users.add(new User("Mary", "Booyko"));
        users.add(new User("Xanadu", "Paradise"));
        users.forEach(userRepository::save);
        //When
        int numberOfRegisteredUsers = userRepository.findAll().size();
        //Then
        Assert.assertEquals(5, numberOfRegisteredUsers);
    }

    @Test
    public void testGetParticularUser() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Smith"));
        users.add(new User("Mark", "Woytkovitz"));
        users.add(new User("Joanna", "Zemla"));
        users.add(new User("Mary", "Booyko"));
        users.add(new User("Xanadu", "Paradise"));
        users.forEach(userRepository::save);
        //When
        String firstNameOfFirstUser = userRepository.getUserByUserId(1L).getUserFirstName();
        String lastNameOfLastUser = userRepository.getUserByUserId(5L).getUserLastName();
        //Then
        Assert.assertEquals("John", firstNameOfFirstUser);
        Assert.assertEquals("Paradise", lastNameOfLastUser);
        //Cleanup
        userRepository.deleteAll();
    }

    @Test
    public void testCreateUser() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Smith"));
        users.forEach(userRepository::save);
        //When
        int numberOfCreatedUsers = userRepository.findAll().size();
        //Then
        Assert.assertEquals(1, numberOfCreatedUsers);
        //Cleanup
        userRepository.deleteAll();
    }

    @Test
    public void testRemoveUser() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("Mark", "Woytkovitz"));
        users.add(new User("Joanna", "Zemla"));
        users.add(new User("Mary", "Booyko"));
        users.add(new User("Xanadu", "Paradise"));
        users.forEach(userRepository::save);
        //When
        userRepository.deleteById(2L);
        int numberOfRegisteredUsersAfterDeletion = userRepository.findAll().size();
        //Then
        Assert.assertEquals(3, numberOfRegisteredUsersAfterDeletion);
        //Cleanup
        userRepository.deleteAll();
    }

    @Test
    public void testUpdateUser() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("Mark", "Woytkovitz"));
        users.add(new User("Joanna", "Zemla"));
        users.add(new User("Mary", "Booyko"));
        users.add(new User("Xanadu", "Paradise"));
        users.forEach(userRepository::save);
        //When
        String changedFirstName = "Zanadu";
        User user = new User(changedFirstName, "Paradise");
        userRepository.save(user, 4L);
        //Then
        Assert.assertEquals(changedFirstName, userRepository.getUserByUserId(4L).getUserFirstName());
        //Cleanup
        userRepository.deleteAll();
    }

    @Test
    public void testRetrieveUsersWithNameContaining() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("Mark", "Woytkovitz"));
        users.add(new User("Joanna", "Zemla"));
        users.add(new User("Mary", "Sue"));
        users.add(new User("Xanadu", "Paradise"));
        users.forEach(userRepository::save);
        //When
        List<User> result = userRepository.retrieveUsersWithNameContaining("Woytkovitz");
        int numberOfFoundUsers = result.size();
        //Then
        Assert.assertEquals(1, numberOfFoundUsers);
        //Cleanup
       // userRepository.deleteAll();
    }

    @Test
    public void testRetrieveUsersWithOverdueLoans() {
        //Given
        List<User> users = new ArrayList<>();
        users.add(new User("Mark", "Woytkovitz"));
        users.add(new User("Joanna", "Zemla"));
        users.add(new User("Mary", "Booyko"));
        users.add(new User("Xanadu", "Paradise"));
        users.forEach(userRepository::save);
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
        bookTitleRepository.save(bookTitle2);
        BookTitle bookTitle3 = new BookTitle("Coun", "Hooppp", 1988);
        bookTitleRepository.save(bookTitle3);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        BookCopy bookCopy3 = new BookCopy(bookTitle2);
        BookCopy bookCopy4 = new BookCopy(bookTitle2);
        BookCopy bookCopy5 = new BookCopy(bookTitle3);
        BookCopy bookCopy6 = new BookCopy(bookTitle3);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        Loan loan1 = new Loan(users.get(1), booksLoaned);
        loanRepository.save(loan1);
        List<BookCopy> booksLoaned2 = new ArrayList<>();
        booksLoaned.add(bookCopy3);
        booksLoaned.add(bookCopy4);
        Loan loan2 = new Loan(users.get(2), booksLoaned2);
        loanRepository.save(loan2);
        List<BookCopy> booksLoaned3 = new ArrayList<>();
        booksLoaned.add(bookCopy5);
        booksLoaned.add(bookCopy6);
        Loan loan3 = new Loan(users.get(3), booksLoaned3);
        loanRepository.save(loan3);
        //When
        int usersWIthOverDueLoans = userRepository.retrieveUsersWithOverdueLoans().size();
        //Then
        Assert.assertEquals(0,usersWIthOverDueLoans);
        //Cleanup
        userRepository.deleteAll();
    }




}
