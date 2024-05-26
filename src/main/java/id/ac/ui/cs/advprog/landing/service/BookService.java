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

    public List<BookDTO> getBestSellers() {
        String url = "http://localhost:7000/book?sortBy=downloadCount";
        RestTemplate restTemplate = new RestTemplate();
        BookDTO[] booksArray = restTemplate.getForObject(url, BookDTO[].class);

        if (booksArray != null) {
            // Sort the books by downloadCount in descending order and limit to top 5
            return Arrays.stream(booksArray)
                    .sorted((b1, b2) -> Integer.compare(b2.getDownloadCount(), b1.getDownloadCount()))
                    .limit(5)
                    .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}