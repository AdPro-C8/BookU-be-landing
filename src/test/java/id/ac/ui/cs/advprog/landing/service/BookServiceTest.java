package id.ac.ui.cs.advprog.landing.service;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private BookServiceImpl bookService;

    private BookDTO[] booksArray;

    @BeforeEach
    public void setUp() {
        booksArray = new BookDTO[]{
                new BookDTO("Book 1", "url1", UUID.randomUUID(), 0),
                new BookDTO("Book 2", "url2", UUID.randomUUID(), 0),
                new BookDTO("Book 3", "url3", UUID.randomUUID(), 0),
                new BookDTO("Book 4", "url4", UUID.randomUUID(), 0),
                new BookDTO("Book 5", "url5", UUID.randomUUID(), 0)
        };
    }

    @Test
    public void testGetBestSellers() throws Exception {
        // Mocking the response of the book list
        when(restTemplate.getForObject(anyString(), (Class<BookDTO[]>) any(Class.class)))
                .thenReturn(booksArray);

        // Mocking the response of the rating API
        when(restTemplate.getForObject(anyString(), (Class<Integer>) any(Class.class)))
                .thenReturn(5);

        CompletableFuture<List<BookDTO>> future = bookService.getBestSellers();

        List<BookDTO> bestSellers = future.get();
        assertNotNull(bestSellers);
        assertEquals(5, bestSellers.size());
        bestSellers.forEach(book -> {
            assertEquals(5, book.getRating());
        });
    }
}
