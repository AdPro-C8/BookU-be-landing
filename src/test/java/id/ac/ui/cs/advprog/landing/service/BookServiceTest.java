package id.ac.ui.cs.advprog.landing.service;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BookService bookService;

    private BookDTO[] booksArray;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        booksArray = new BookDTO[]{
                new BookDTO("Book 1", "https://example.com/photo1.jpg", UUID.randomUUID()),
                new BookDTO("Book 2", "https://example.com/photo2.jpg", UUID.randomUUID())
        };
    }

    @Test
    void testGetBestSellersDownloadCount() {
        String url = "http://localhost:8003/book?sortBy=downloadCount&orderBy=desc";
        given(restTemplate.getForObject(url, BookDTO[].class)).willReturn(booksArray);

        List<BookDTO> bestSellers = bookService.getBestSellers();

        assertEquals(2, bestSellers.size());
        assertEquals("Book 1", bestSellers.get(0).getTitle());
        assertEquals("Book 2", bestSellers.get(1).getTitle());

        verify(restTemplate, times(1)).getForObject(url, BookDTO[].class);
    }

    @Test
    void testGetBestSellersWhenNoBooksDownloadCount() {
        String url = "http://localhost:8003/book?sortBy=downloadCount&orderBy=desc";
        given(restTemplate.getForObject(url, BookDTO[].class)).willReturn(null);

        List<BookDTO> bestSellers = bookService.getBestSellers();

        assertTrue(bestSellers.isEmpty());

        verify(restTemplate, times(1)).getForObject(url, BookDTO[].class);
    }


    @Test
    void testGetBestSellersRating() {
        String url = "http://localhost:8003/book?sortBy=rating&orderBy=desc";
        given(restTemplate.getForObject(url, BookDTO[].class)).willReturn(booksArray);

        List<BookDTO> bestSellers = bookService.getBestSellers();

        assertEquals(2, bestSellers.size());
        assertEquals("Book 1", bestSellers.get(0).getTitle());
        assertEquals("Book 2", bestSellers.get(1).getTitle());

        verify(restTemplate, times(1)).getForObject(url, BookDTO[].class);
    }

    @Test
    void testGetBestSellersWhenNoBooksRating() {
        String url = "http://localhost:8003/book?sortBy=rating&orderBy=desc";
        given(restTemplate.getForObject(url, BookDTO[].class)).willReturn(null);

        List<BookDTO> bestSellers = bookService.getBestSellers();

        assertTrue(bestSellers.isEmpty());

        verify(restTemplate, times(1)).getForObject(url, BookDTO[].class);
    }
}
