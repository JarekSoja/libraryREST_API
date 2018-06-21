package com.library.api.controller;

import com.google.gson.Gson;
import com.library.api.domain.BookCopy;
import com.library.api.domain.BookTitle;
import com.library.api.domain.Loan;
import com.library.api.domain.User;
import com.library.api.dto.BookCopyDto;
import com.library.api.dto.BookTitleDto;
import com.library.api.mapper.BookCopyMapper;
import com.library.api.mapper.BookTitleMapper;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
import com.library.api.service.BookCopyService;
import com.library.api.service.BookTitleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class BookControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookTitleRepository bookTitleRepository;

    @MockBean
    private BookCopyRepository bookCopyRepository;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private LoanRepository loanRepository;

    @MockBean
    BookTitleMapper bookTitleMapper;

    @MockBean
    BookCopyMapper bookCopyMapper;

    @MockBean
    private BookTitleService bookTitleService;

    @MockBean
    private BookCopyService bookCopyService;


    @Test
    public void testGetAllBookTitles() throws Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        List<BookTitle> bookTitles = new ArrayList<>();
        BookTitleDto bookTitle1Dto = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        List<BookTitleDto> bookTitleDtos = new ArrayList<>();
        bookTitleDtos.add(bookTitle1Dto);
        bookTitles.add(bookTitle1);
        when(bookTitleService.getAllBookTitles()).thenReturn(bookTitles);
        when(bookTitleMapper.mapToBookTitleDtoList(any(List.class))).thenReturn(bookTitleDtos);

        //When&&Then
        mockMvc.perform(get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.[0].author", is("Ggttttt")));

    }

    @Test
    public void testGetSingleBook() throws Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitleDto bookTitle1Dto = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        when(bookTitleService.getBookTitleById(anyLong())).thenReturn(bookTitle1);
        when(bookTitleMapper.mapToBookTitleDto(any(BookTitle.class))).thenReturn(bookTitle1Dto);

        //When&&Then
        mockMvc.perform(get("/books/555")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Ababav Bababav")));
    }

    @Test
    public void testCreateBookTitle() throws Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        when(bookTitleService.saveBookTitle(any(BookTitle.class))).thenReturn(bookTitle1);
        when(bookTitleMapper.mapToBookTitle(any(BookTitleDto.class))).thenReturn(bookTitle1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookTitle1);

        //When&&Then
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author", is("Ggttttt")));
    }

    @Test
    public void testDeleteBookTitle() throws Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitle bookTitle2 = new BookTitle("Bababav Cececev", "Reee", 1999);
        List<BookTitle> bookTitles = new ArrayList<>();
        bookTitles.add(bookTitle1);
        bookTitles.add(bookTitle2);

        //When&Then
        mockMvc.perform(delete("/books/444"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateBookTitle() throws Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitleDto bookTitleDto2 = new BookTitleDto("Bababav Cececev", "Reee", 1999);

        when(bookTitleService.saveBookTitle(any(BookTitle.class))).thenReturn(bookTitle1);
        when(bookTitleMapper.mapToBookTitle(any(BookTitleDto.class))).thenReturn(bookTitle1);
        when(bookTitleMapper.mapToBookTitleDto(any(BookTitle.class))).thenReturn(bookTitleDto2);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookTitle1);

        //When&Then
        mockMvc.perform(put("/books/")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author", is("Reee")));
    }


    @Test
    public void testSearchBookTitles() throws  Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitleDto bookTitleDto2 = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        List<BookTitle> bookTitleList = new ArrayList<>();
        List<BookTitleDto> bookTitleDtoList = new ArrayList<>();
        bookTitleList.add(bookTitle1);
        bookTitleDtoList.add(bookTitleDto2);

        when(bookTitleService.saveBookTitle(any(BookTitle.class))).thenReturn(bookTitle1);
        when(bookTitleMapper.mapToBookTitle(any(BookTitleDto.class))).thenReturn(bookTitle1);
        when(bookTitleMapper.mapToBookTitleDto(any(BookTitle.class))).thenReturn(bookTitleDto2);
        when(bookTitleService.getBookTitleWithAuthor(anyString())).thenReturn(bookTitleList);
        when(bookTitleMapper.mapToBookTitleDtoList(any(List.class))).thenReturn(bookTitleDtoList);

        //When&Then
        mockMvc.perform(get("/books/search/?title=Ababav&author=Ggttttt")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].author", is("Ggttttt")));

    }

    @Test
    public void testRetrieveTitlesWithAvailableCopies() throws Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        List<BookTitle> titles = new ArrayList<>();
        titles.add(bookTitle1);
        BookTitleDto bookTitleDto1 = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        List<BookTitleDto> titlesDto = new ArrayList<>();
        titlesDto.add(bookTitleDto1);


        when(bookTitleService.getAllTitlesWithAvailableCopies()).thenReturn(titles);
        when(bookTitleMapper.mapToBookTitleDtoList(any(List.class))).thenReturn(titlesDto);

        //When&&Then
        mockMvc.perform(get("/books/available")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].author", is("Ggttttt")));

    }

    @Test
    public void testGetBookCopyById() throws  Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitleDto bookTitleDto1 = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopyDto bookCopyDto2 = new BookCopyDto(bookTitleDto1);
        List<BookTitle> titles = new ArrayList<>();
        titles.add(bookTitle1);

        when(bookCopyService.getBookCopyById(anyLong())).thenReturn(bookCopy1);
        when(bookCopyMapper.mapToBookCopyDto(any(BookCopy.class))).thenReturn(bookCopyDto2);

        //When&&Then
        mockMvc.perform(get("/books/copies/333")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bookTitleDto.title", is("Ababav Bababav")));
    }

    @Test
    public void testGetAllCopiesByTitle() throws Exception {
        //Given
        BookTitle bookTitle1 = new BookTitle("Ababav Bababav", "Ggttttt", 1999);
        BookTitleDto bookTitleDto1 = new BookTitleDto("Ababav Bababav", "Ggttttt", 1999);
        BookCopy bookCopy1 = new BookCopy(bookTitle1);
        BookCopyDto bookCopyDto2 = new BookCopyDto(bookTitleDto1);
        List<BookCopyDto> bookCopyDtoList = new ArrayList<>();
        bookCopyDtoList.add(bookCopyDto2);
        List<BookCopy> bookCopyList = new ArrayList<>();
        bookCopyList.add(bookCopy1);

        when(bookCopyService.getAllCopiesOfTitle(any(BookTitle.class))).thenReturn(bookCopyList);
        when(bookCopyMapper.mapToBookCopyDtoList(any(List.class))).thenReturn(bookCopyDtoList);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookTitle1);

        //When&Then
        mockMvc.perform(get("/books/copies/")
                .param("title", jsonContent))
             //   .contentType(MediaType.APPLICATION_JSON)
            //    .characterEncoding("UTF-8")
             //   .content(jsonContent))
                .andExpect(status().isOk());
    }

}
