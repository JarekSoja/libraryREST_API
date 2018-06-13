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

//    BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
//        bookTitleRepository.save(bookTitle1);
//    BookTitle bookTitle2 = new BookTitle("Bcauu Buooor", "Nouty", 2012);
//        bookTitleRepository.save(bookTitle2);
//    BookTitle bookTitle3 = new BookTitle("Coun", "Hooppp", 1988);
//        bookTitleRepository.save(bookTitle3);
//    BookTitle bookTitle4 = new BookTitle("Dumbo", "Sfsdfsd", 1934);
//        bookTitleRepository.save(bookTitle4);
//    BookTitle bookTitle5 = new BookTitle("Edvard IV", "BBBBb", 1966);
//        bookTitleRepository.save(bookTitle5);
//    BookTitle bookTitle6 = new BookTitle("Father John", "Geaaaaa", 1981);
//        bookTitleRepository.save(bookTitle6);
//    BookCopy bookCopy1 = new BookCopy(bookTitle1);
//        bookCopyRepository.save(bookCopy1);
//    BookCopy bookCopy2 = new BookCopy(bookTitle1);
//        bookCopyRepository.save(bookCopy2);
//    BookCopy bookCopy3 = new BookCopy(bookTitle2);
//        bookCopyRepository.save(bookCopy3);
//    BookCopy bookCopy4 = new BookCopy(bookTitle2);
//        bookCopyRepository.save(bookCopy4);
//    BookCopy bookCopy5 = new BookCopy(bookTitle3);
//        bookCopyRepository.save(bookCopy5);
//    BookCopy bookCopy6 = new BookCopy(bookTitle3);
//        bookCopyRepository.save(bookCopy6);
//    BookCopy bookCopy7 = new BookCopy(bookTitle4);
//        bookCopyRepository.save(bookCopy7);
//    BookCopy bookCopy8 = new BookCopy(bookTitle4);
//        bookCopyRepository.save(bookCopy8);
//    BookCopy bookCopy9 = new BookCopy(bookTitle4);
//        bookCopyRepository.save(bookCopy9);
//    BookCopy bookCopy10 = new BookCopy(bookTitle5);
//        bookCopyRepository.save(bookCopy10);
//    BookCopy bookCopy11 = new BookCopy(bookTitle5);
//        bookCopyRepository.save(bookCopy11);
//    BookCopy bookCopy12 = new BookCopy(bookTitle6);
//        bookCopyRepository.save(bookCopy12);


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
//
//
//    public void removeBookTitle(@PathVariable("id") Long bookTitleId, @PathVariable("copyId") Long bookCopyId) {
//    }
//
//
//    public List<BookTitleDto> findBookTitlesByYearOfPublishing(@RequestParam(value = "year") Integer year) {
//
//    }

}