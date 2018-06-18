package com.library.api.service;

import com.library.api.domain.BookTitle;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
    public void clearData() {
        bookTitleRepository.deleteAll();
        bookCopyRepository.deleteAll();
    }

    @Test
    public void testGetAllBookTitles() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
        bookTitleRepository.save(bookTitle2);
        BookTitle bookTitle3 = new BookTitle("Coun", "Hooppp", 1988);
        bookTitleRepository.save(bookTitle3);
        BookTitle bookTitle4 = new BookTitle("Dumbo", "Sfsdfsd", 1934);
        bookTitleRepository.save(bookTitle4);
        BookTitle bookTitle5 = new BookTitle("Edvard IV", "BBBBb", 1966);
        bookTitleRepository.save(bookTitle5);
        BookTitle bookTitle6 = new BookTitle("Father John", "Geaaaaa", 1981);
        bookTitleRepository.save(bookTitle6);
        //When
        List<BookTitle> testList = bookTitleRepository.findAll();
        int testSize = testList.size();
        //Then
        Assert.assertEquals(6, testSize);
    }

    @Test
    public void testGetBookTitleDetailId() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        //When
        long testId = bookTitle1.getBookTitleId();
        String testTitle = bookTitleRepository.findByBookTitleId(testId).getTitle();
        //Then
        Assert.assertEquals("Ababav Bababav", testTitle);
    }


    @Test
    public void testRemoveBookTitle() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
        bookTitleRepository.save(bookTitle2);
        //When
        long testId = bookTitle1.getBookTitleId();
        bookTitleRepository.deleteById(testId);
        List<BookTitle> testList = bookTitleRepository.findAll();
        int testSize = testList.size();
        //Then
        Assert.assertEquals(1, testSize);
    }
}