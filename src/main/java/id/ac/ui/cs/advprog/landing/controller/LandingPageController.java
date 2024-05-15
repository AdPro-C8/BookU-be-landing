package id.ac.ui.cs.advprog.landing.controller;

import id.ac.ui.cs.advprog.landing.model.Book;
import id.ac.ui.cs.advprog.landing.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LandingPageController {
    private final BookService bookService;

    @Autowired
    public LandingPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public String getBestSellers(Model model) {
        List<Book> bestSellers = bookService.getTop5BooksBySales();
        model.addAttribute("bestSellers", bestSellers);
        return "landing-page";
    }

}
