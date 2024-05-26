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
@RequestMapping("api/landing")
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

    @GetMapping("/bestsellers")
    public ResponseEntity<List<BookDTO>> getBestSellers() {
        List<BookDTO> bestSellers = bookService.getBestSellers();
        return ResponseEntity.ok(bestSellers);
    }
}
