package com.library.api.controller;

import com.google.gson.Gson;
import com.library.api.domain.BookTitle;
import com.library.api.dto.BookTitleDto;
import com.library.api.mapper.BookCopyMapper;
import com.library.api.mapper.BookTitleMapper;
import com.library.api.repository.BookCopyRepository;
import com.library.api.repository.BookTitleRepository;
import com.library.api.repository.LoanRepository;
import com.library.api.repository.UserRepository;
import com.library.api.service.BookTitleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

}
