package id.ac.ui.cs.advprog.landing.service;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    public List<BookDTO> getBestSellersByDownloadCount() {
        String url = "http://localhost:8003/book?sortBy=downloadCount&orderBy=desc";
        RestTemplate restTemplate = new RestTemplate();
        BookDTO[] booksArray = restTemplate.getForObject(url, BookDTO[].class);

        if (booksArray != null) {
            return Arrays.stream(booksArray)
                    .limit(5)
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public List<BookDTO> getBestSellersByRating() {
        String url = "http://localhost:8003/book?sortBy=rating&orderBy=desc";
        RestTemplate restTemplate = new RestTemplate();
        BookDTO[] booksArray = restTemplate.getForObject(url, BookDTO[].class);

        if (booksArray != null) {
            return Arrays.stream(booksArray)
                    .limit(5)
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}
