package com.library.api.service;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.mapper.BookCopyMapper;
import com.library.api.mapper.BookTitleMapper;
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
public class BookCopyServiceTestSuite {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookTitleRepository bookTitleRepository;

    @Autowired
    BookCopyRepository bookCopyRepository;

    @Autowired
    BookCopyMapper bookCopyMapper;

    @Autowired
    BookTitleMapper bookTitleMapper;

    @Autowired
    BookCopyService bookCopyService;

    @Before
    public void clearData() {
        bookTitleRepository.deleteAll();
        bookCopyRepository.deleteAll();
    }


    @Test
    public void testGetBookCopyDetailId() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        bookCopyRepository.save(bookCopy1);
        //When
        long testId = bookCopy1.getBookCopyId();
        BookCopy testedCopy = bookCopyRepository.getByBookCopyId(testId);
        String testedTitle = testedCopy.getBookTitle().getTitle();
        //Then
        Assert.assertEquals(testedTitle, "Ababav Bababav");
    }

    @Test
    public void testGetAllBookCopiesByTitle() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
        bookTitleRepository.save(bookTitle2);
        BookTitle bookTitle3 = new BookTitle("Coun", "Hooppp", 1988);
        bookTitleRepository.save(bookTitle3);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        bookCopyRepository.save(bookCopy1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        bookCopyRepository.save(bookCopy2);
        BookCopy bookCopy3 = new BookCopy(bookTitle2);
        bookCopyRepository.save(bookCopy3);
        BookCopy bookCopy4 = new BookCopy(bookTitle2);
        bookCopyRepository.save(bookCopy4);
        BookCopy bookCopy5 = new BookCopy(bookTitle3);
        bookCopyRepository.save(bookCopy5);
        BookCopy bookCopy6 = new BookCopy(bookTitle3);
        bookCopyRepository.save(bookCopy6);
        //When
        List<BookCopy> testList = bookCopyRepository.getAllByBookTitle(bookTitle1);
        int testSize = testList.size();
        //Then
        Assert.assertEquals(testSize, 2);
    }
//
    @Test
    public void testUpdateBookCopy() {
        //Given
        BookTitle bookTitle6 = new BookTitle("Father John", "Geaaaaa", 1981);
        BookTitle bookTitle5 = new BookTitle("Edvard IV", "BBBBb", 1966);
        bookTitleRepository.save(bookTitle6);
        bookTitleRepository.save(bookTitle5);
        BookCopy bookCopy1 = new BookCopy(bookTitle6);
        bookCopyRepository.save(bookCopy1);
        //When
        bookCopy1.setBookTitle(bookTitle5);
        bookCopyRepository.save(bookCopy1);
        long testId = bookCopy1.getBookCopyId();
        String testTitle = bookCopyRepository.getByBookCopyId(testId).getBookTitle().getTitle();
        //Then
        Assert.assertEquals("Edvard IV", testTitle);
    }

    @Test
    public void testFetchAllAvailableCopies() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        bookTitleRepository.save(bookTitle1);
        BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
        bookTitleRepository.save(bookTitle2);
        BookTitle bookTitle3 = new BookTitle("Coun", "Hooppp", 1988);
        bookTitleRepository.save(bookTitle3);
        BookTitle bookTitle4 = new BookTitle("Dumbo", "Sfsdfsd", 1934);
        bookTitleRepository.save(bookTitle4);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        bookCopy1.setAvailable(false);
        bookCopyRepository.save(bookCopy1);
        BookCopy bookCopy2 = new BookCopy(bookTitle1);
        bookCopyRepository.save(bookCopy2);
        BookCopy bookCopy3 = new BookCopy(bookTitle2);
        bookCopyRepository.save(bookCopy3);
        BookCopy bookCopy4 = new BookCopy(bookTitle2);
        bookCopy4.setAvailable(false);
        bookCopyRepository.save(bookCopy4);
        BookCopy bookCopy5 = new BookCopy(bookTitle3);
        bookCopyRepository.save(bookCopy5);
        BookCopy bookCopy6 = new BookCopy(bookTitle3);
        bookCopyRepository.save(bookCopy6);
        BookCopy bookCopy7 = new BookCopy(bookTitle4);
        bookCopyRepository.save(bookCopy7);
        BookCopy bookCopy8 = new BookCopy(bookTitle4);
        bookCopyRepository.save(bookCopy8);
        BookCopy bookCopy9 = new BookCopy(bookTitle4);
        bookCopy9.setAvailable(false);
        bookCopyRepository.save(bookCopy9);
        //When
        List<BookCopy> testAvailableBooks = bookCopyRepository.getBookCopiesByAvailable();
        //Then
        Assert.assertEquals(6, testAvailableBooks.size());
    }
}