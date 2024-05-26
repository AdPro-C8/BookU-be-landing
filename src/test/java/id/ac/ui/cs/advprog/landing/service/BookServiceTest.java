package id.ac.ui.cs.advprog.landing.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class BookServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetBestSellers() {
        BookDTO[] mockResponse = {
                new BookDTO("Book 1", 100, "https://example.com/photo1.jpg", UUID.randomUUID()),
                new BookDTO("Book 2", 200, "https://example.com/photo2.jpg", UUID.randomUUID()),
                new BookDTO("Book 3", 300, "https://example.com/photo3.jpg", UUID.randomUUID()),
                new BookDTO("Book 4", 400, "https://example.com/photo4.jpg", UUID.randomUUID()),
                new BookDTO("Book 5", 500, "https://example.com/photo5.jpg", UUID.randomUUID())
        };

        when(restTemplate.getForObject(anyString(), eq(BookDTO[].class))).thenReturn(mockResponse);

        List<BookDTO> bestSellers = bookService.getBestSellers();

        assertNotNull(bestSellers);
        assertEquals(5, bestSellers.size());
        assertEquals("Book 5", bestSellers.get(0).getTitle());
        assertEquals("Book 1", bestSellers.get(4).getTitle());
    }
}
