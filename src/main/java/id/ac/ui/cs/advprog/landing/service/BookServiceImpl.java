package id.ac.ui.cs.advprog.landing.service;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final RestTemplate restTemplate;

    public BookServiceImpl() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    @Async
    public CompletableFuture<List<BookDTO>> getBestSellers() {
        String url = "http://localhost:7000/book?sortBy=rating&orderBy=desc";
        BookDTO[] booksArray = restTemplate.getForObject(url, BookDTO[].class);

        if (booksArray != null) {
            List<BookDTO> books = Arrays.stream(booksArray)
                    .limit(5)
                    .collect(Collectors.toList());

            List<CompletableFuture<BookDTO>> futures = books.stream()
                    .map(book -> CompletableFuture.supplyAsync(() -> {
                        Integer rating = fetchRating(book.getId());
                        book.setRating(rating);
                        return book;
                    }))
                    .collect(Collectors.toList());

            CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                    futures.toArray(new CompletableFuture[0])
            );

            return allFutures.thenApply(v -> futures.stream()
                    .map(CompletableFuture::join)
                    .collect(Collectors.toList())
            );
        } else {
            return CompletableFuture.completedFuture(Arrays.asList());
        }
    }

    private Integer fetchRating(UUID bookId) {
        String url = "http://localhost:7000/rating/by/book-id?bookId=" + bookId;
        return restTemplate.getForObject(url, Integer.class);
    }
}
