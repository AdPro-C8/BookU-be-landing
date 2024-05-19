package id.ac.ui.cs.advprog.landing.controller;

import id.ac.ui.cs.advprog.landing.model.Book;
import id.ac.ui.cs.advprog.landing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("landing")
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
        for (int i=1; i<6; i++) {
            Book newBook = new Book(UUID.randomUUID(), "title", "www.adproanjing");
            bookService.fetchBook(newBook);
        }

        List<Book> bestSellers = bookService.getBooks();
        return ResponseEntity.ok(bestSellers);
    }

}
