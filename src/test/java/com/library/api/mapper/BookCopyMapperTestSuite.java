package com.library.api.mapper;

import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.dto.BookCopyDto;
import com.library.api.dto.BookTitleDto;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookCopyMapperTestSuite {

    @Autowired
    private BookCopyMapper bookCopyMapper;

    @Autowired
    private BookCopyRepository bookCopyRepository;

    @Autowired
    private BookTitleRepository bookTitleRepository;

    @Autowired
    UserRepository userRepository;

    @Before
    public void clearData() {
        bookTitleRepository.deleteAll();
        bookCopyRepository.deleteAll();
    }

    @Test
    public void testMapToBookCopyDto() {
        //Given
        User user = new User("1", "2");
        BookTitle bookTitle = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        List<BookCopy> loaned = new ArrayList<>();
        Loan loan = new Loan(1L, user, loaned, LocalDate.now(), LocalDate.now().plusDays(14));
        BookCopy bookCopy = new BookCopy(bookTitle);
        loaned.add(bookCopy);
        bookCopy.setLoan(loan);
        bookTitle.setListOfCopies(loaned);

        //When
        BookCopyDto testDto = bookCopyMapper.mapToBookCopyDto(bookCopy);
        String testedAuthor = testDto.getBookTitleDto().getAuthor();
        //Then
        Assert.assertEquals( "Ggttttt", testedAuthor);
    }

    @Test
    public void testMapToBookCopy() {
        //Given
        BookTitleDto bookTitleDto = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        BookCopyDto bookCopyDto = new BookCopyDto(bookTitleDto);
        //When
        BookCopy testBook = bookCopyMapper.mapToBookCopy(bookCopyDto);
        String testedAuthor = testBook.getBookTitle().getAuthor();
        //Then
        Assert.assertEquals( "Ggttttt", testedAuthor);
    }

    @Test
    public void testMapToBookCopyDtoList() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitle bookTitle2 = new BookTitle("Cece keke", "AAA", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopy bookCopy2 = new BookCopy(bookTitle2);
        List<BookCopy> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        //When
        List<BookCopyDto> listDto = bookCopyMapper.mapToBookCopyDtoList(booksLoaned);
        String testTitle = listDto.get(0).getBookTitleDto().getTitle();
        String testAuthor = listDto.get(1).getBookTitleDto().getAuthor();
        //Then
        Assert.assertEquals("Ababav Bababav", testTitle);
        Assert.assertEquals("AAA", testAuthor);
    }

    @Test
    public void testMapToBookCopyList() {
        //Given
        BookTitleDto bookTitle1 = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        BookTitleDto bookTitle2 = new BookTitleDto("Cece keke", "AAA", 1999);
        BookCopyDto bookCopy1 = new BookCopyDto(bookTitle1);
        BookCopyDto bookCopy2 = new BookCopyDto(bookTitle2);
        List<BookCopyDto> booksLoaned = new ArrayList<>();
        booksLoaned.add(bookCopy1);
        booksLoaned.add(bookCopy2);
        //When
        List<BookCopy> list = bookCopyMapper.mapToBookCopyList(booksLoaned);
        String testTitle = list.get(0).getBookTitle().getTitle();
        String testAuthor = list.get(1).getBookTitle().getAuthor();
        //Then
        Assert.assertEquals("Ababav Bababav", testTitle);
        Assert.assertEquals("AAA", testAuthor);
    }
}
