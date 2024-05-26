package id.ac.ui.cs.advprog.landing.controller;

import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import id.ac.ui.cs.advprog.landing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/landing")
public class LandingPageController {

    private final BookService bookService;

    @Autowired
    public LandingPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home() {
        return "landing_page";  // No need to add .html, Spring Boot resolves it automatically
    }

    @GetMapping("/bestsellers/download-count")
    public ResponseEntity<List<BookDTO>> getBestSellersByDownloadCount() {
        List<BookDTO> bestSellers = bookService.getBestSellersByDownloadCount();
        return ResponseEntity.ok(bestSellers);
    }

    @GetMapping("/bestsellers/rating")
    public ResponseEntity<List<BookDTO>> getBestSellersByRating() {
        List<BookDTO> bestSellers = bookService.getBestSellersByRating();
        return ResponseEntity.ok(bestSellers);
    }
}
