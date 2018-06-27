package com.library.api.mapper;

import com.library.api.domain.BookTitle;
import com.library.api.dto.BookTitleDto;
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
public class BookTitleMapperTestSuite {

    @Autowired
    private BookTitleMapper bookTitleMapper;

    @Test
    public void testMapToBookTitleDto(){
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);

        //When
        BookTitleDto bookTitleDto = bookTitleMapper.mapToBookTitleDto(bookTitle1);
        String testTitle = bookTitleDto.getTitle();

        //Then
        Assert.assertEquals("Ababav Bababav", testTitle);
    }

    @Test
    public void testMapToBookTitle(){
        //Given
        BookTitleDto bookTitleDto = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);

        //When
        BookTitle bookTitle = bookTitleMapper.mapToBookTitle(bookTitleDto);
        String testTitle = bookTitle.getTitle();

        //Then
        Assert.assertEquals("Ababav Bababav", testTitle);
    }

    @Test
    public void testMapToBookTitleDtoList() {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitle bookTitle2 = new BookTitle("Frreeee", "Breeg", 2012);
        BookTitle bookTitle3 = new BookTitle("Lord", "Nujow", 1945);
        List<BookTitle> bookTitles = new ArrayList<>();
        bookTitles.add(bookTitle1);
        bookTitles.add(bookTitle2);
        bookTitles.add(bookTitle3);

        //When
        List<BookTitleDto> testList = bookTitleMapper.mapToBookTitleDtoList(bookTitles);
        String testTitle = testList.get(0).getTitle();
        String testAuthor = testList.get(1).getAuthor();
        int testYear = testList.get(2).getYearOfPublishing();

        //Then
        Assert.assertEquals("Ababav Bababav", testTitle);
        Assert.assertEquals("Breeg", testAuthor);
        Assert.assertEquals(testYear, 1945);
    }
}
