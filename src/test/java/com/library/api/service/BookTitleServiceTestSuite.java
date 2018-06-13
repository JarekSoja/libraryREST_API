package com.library.api.service;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTitleServiceTestSuite {

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
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    @Test
//    public void test
    //Given
    //When
    //Then
//
//    public List<BookTitleDto> getAllBookTitles() {
//    }
//
//    public BookTitleDto getBookTitleDetailId(@PathVariable("id") Long bookTitleId) {
//    }
//
//    public void createBookTitle(@RequestBody BookTitleDto bookTitleDto) {
//    }
//
//    public void removeBookTitle(@PathVariable("id") Long bookTitleId) {
//    }
//
//    public BookTitleDto updateBookTitle(@PathVariable("id") Long bookCopyId, @RequestBody BookTitleDto bookTitleDto) {
//    }
//
//    public List<BookTitleDto> findBookTitles(@RequestParam(value = "author", required = false) String author,
//                                             @RequestParam(value = "title", required = false) String title) {
//    }
//
//    public List<BookTitleDto> retrieveBookTitlesWithAvailableCopies() {
//    }
//
//    public BookCopyDto getBookCopyDetailId(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
//    }
//
//    public List<BookCopyDto> getAllBookCopiesByTitle(@PathVariable("id") Long bookTitleId) {
//    }
//
//    public void newBookCopy(@RequestBody BookCopyDto bookCopyDto) {
//    }
//
//    public void removeBookTitle(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
//    }
//
//    public BookCopyDto updateBookCopy( @PathVariable("copyId") Long bookCopyId, @RequestBody BookCopyDto bookCopyDto) {
//
//    }
//
//    public List<BookTitleDto> findBookTitlesByYearOfPublishing(@RequestParam(value = "year") Integer year) {
//
//    }
//
//    public List<BookCopyDto> fetchAllAvailableCopies() {
//    }
}