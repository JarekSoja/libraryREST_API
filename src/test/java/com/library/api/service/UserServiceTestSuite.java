package com.library.api.service;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
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
public class UserServiceTestSuite {

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
        userRepository.deleteAll();
        List<User> users = new ArrayList<>();
        User user1 = new User("John", "Smith");
        userRepository.save(user1);
        User user2 = new User("Mark", "Woytkovitz");
        userRepository.save(user2);
        //When
        int numberOfRegisteredUsers = userRepository.findAll().size();
        //Then
        Assert.assertEquals(2, numberOfRegisteredUsers);
    }

    @Test
    public void testGetParticularUser() {
        //Given
        userRepository.deleteAll();
        User user1 = new User("John", "Smith");
        userRepository.save(user1);
        User user2 = new User("Mark", "Woytkovitz");
        userRepository.save(user2);
        User user3 = new User("Joanna", "Zemla");
        userRepository.save(user3);
        User user4 = new User("Mary", "Booyko");
        userRepository.save(user4);
        User user5 = new User("Xanadu", "Paradise");
        userRepository.save(user5);
        //When
        long user1Id = user1.getUserId();
        long user5Id = user5.getUserId();
        String firstNameOfFirstUser = userRepository.getUserByUserId(user1Id).getUserFirstName();
        String lastNameOfLastUser = userRepository.getUserByUserId(user5Id).getUserLastName();
        //Then
        Assert.assertEquals("John", firstNameOfFirstUser);
        Assert.assertEquals("Paradise", lastNameOfLastUser);
    }

    @Test
    public void testCreateUser() {
        //Given
        userRepository.deleteAll();
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Smith"));
        users.forEach(userRepository::save);
        //When
        int numberOfCreatedUsers = userRepository.findAll().size();
        //Then
        Assert.assertEquals(1, numberOfCreatedUsers);
    }

    @Test
    public void testRemoveUser() {
        //Given
        userRepository.deleteAll();
        User user1 = new User("Mark", "Woytkovitz");
        userRepository.save(user1);
        User user2 = new User("Joanna", "Zemla");
        userRepository.save(user2);
        User user3 = new User("Mary", "Booyko");
        userRepository.save(user3);
        User user4 = new User("Xanadu", "Paradise");
        userRepository.save(user4);
        //When
        long userId = user1.getUserId();
        userRepository.deleteById(userId);
        int numberOfRegisteredUsersAfterDeletion = userRepository.findAll().size();
        //Then
        Assert.assertEquals(3, numberOfRegisteredUsersAfterDeletion);
    }

    @Test
    public void testUpdateUser() {
        //Given
        userRepository.deleteAll();
        User user1 = new User("Mark", "Woytkovitz");
        userRepository.save(user1);
        //When
        String changedFirstName = "Zanadu";
        user1.setUserFirstName(changedFirstName);
        userRepository.save(user1);
        //Then
        Assert.assertEquals(changedFirstName, userRepository.getUserByUserId(user1.getUserId()).getUserFirstName());
    }

    @Test
    public void testRetrieveUsersWithNameContaining() {
        //Given
        userRepository.deleteAll();
        User user1 = new User("Mark", "Woytkovitz");
        userRepository.save(user1);
        User user2 = new User("Joanna", "Zemla");
        userRepository.save(user2);
        User user3 = new User("Mary", "Sue");
        userRepository.save(user3);
        User user4 = new User("Xanadu", "Paradise");
        userRepository.save(user4);
        //When
        List<User> result = userRepository.retrieveUsersWithNameContaining("Woytkovitz");
        int numberOfFoundUsers = result.size();
        //Then
        Assert.assertEquals(1, numberOfFoundUsers);
    }

    @Test
    public void testRetrieveUsersWithOverdueLoans() {
        //Given
        userRepository.deleteAll();
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
        Assert.assertEquals(0, usersWIthOverDueLoans);
    }

}