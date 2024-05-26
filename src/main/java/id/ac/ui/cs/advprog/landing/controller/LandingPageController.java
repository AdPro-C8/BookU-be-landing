package id.ac.ui.cs.advprog.landing.controller;

import id.ac.ui.cs.advprog.landing.model.Book;
import id.ac.ui.cs.advprog.landing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/landing")
public class LandingPageController {
    private final BookService bookService;

    @GetMapping("/")
    public String home() {
        return "landing_page";  // No need to add .html, Spring Boot resolves it automatically
    }

    @Autowired
    public LandingPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<?> getBestSellers(Model model) {
        String url = "http://localhost:7000/book?sortBy=downloadCount";
        RestTemplate restTemplate = new RestTemplate();
        Book[] booksArray = restTemplate.getForObject(url, Book[].class);

        List<Book> newBooks = Arrays.stream(booksArray)
                .map(book -> new Book(book.getTitle(), book.getDownloadCount(), book.getPhotoUrl(), book.getId()))
                .toList();
        return ResponseEntity.ok(booksArray);
    }

}
