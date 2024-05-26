package id.ac.ui.cs.advprog.landing.functional;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import id.ac.ui.cs.advprog.landing.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LandingPageController.class)
public class LandingPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    private List<BookDTO> bookList;

    @BeforeEach
    void setUp() {
        bookList = Arrays.asList(
                new BookDTO("Book 1", "https://example.com/photo1.jpg", UUID.randomUUID()),
                new BookDTO("Book 2", "https://example.com/photo2.jpg", UUID.randomUUID())
        );

        given(bookService.getBestSellers()).willReturn(bookList);
    }

    @Test
    public void testGetBestSellers() throws Exception {
        mockMvc.perform(get("/api/landing/bestsellers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.length()").value(bookList.size()))
                .andExpect(jsonPath("$[0].title").value(bookList.get(0).getTitle()))
                .andExpect(jsonPath("$[0].photoUrl").value(bookList.get(0).getPhotoUrl()))
                .andExpect(jsonPath("$[0].id").value(bookList.get(0).getId().toString()))
                .andExpect(jsonPath("$[1].title").value(bookList.get(1).getTitle()))
                .andExpect(jsonPath("$[1].photoUrl").value(bookList.get(1).getPhotoUrl()))
                .andExpect(jsonPath("$[1].id").value(bookList.get(1).getId().toString()));
    }
}
