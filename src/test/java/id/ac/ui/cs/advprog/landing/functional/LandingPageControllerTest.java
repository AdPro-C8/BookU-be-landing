package id.ac.ui.cs.advprog.landing.functional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import id.ac.ui.cs.advprog.landing.controller.LandingPageController;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import id.ac.ui.cs.advprog.landing.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LandingPageController.class)
public class LandingPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBestSellers() throws Exception {
        BookDTO book1 = new BookDTO("Book 1", 100, "https://example.com/photo1.jpg", UUID.randomUUID());
        BookDTO book2 = new BookDTO("Book 2", 200, "https://example.com/photo2.jpg", UUID.randomUUID());
        List<BookDTO> mockBooks = Arrays.asList(book1, book2);

        when(bookService.getBestSellers()).thenReturn(mockBooks);

        mockMvc.perform(get("/bestsellers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Book 1"))
                .andExpect(jsonPath("$[1].title").value("Book 2"))
                .andExpect(jsonPath("$.length()").value(2));
    }
}
