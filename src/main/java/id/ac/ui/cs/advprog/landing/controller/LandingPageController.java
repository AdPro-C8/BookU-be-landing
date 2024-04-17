package id.ac.ui.cs.advprog.landing.controller;

import id.ac.ui.cs.advprog.landing.model.Book;
import id.ac.ui.cs.advprog.landing.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class LandingPageController {

    private final LandingPageService landingPageService;

    @Autowired
    public LandingPageController(LandingPageService landingPageService) {
        this.landingPageService = landingPageService;
    }

    @GetMapping("/")
    public String showLandingPage(Model model) {
        List<Book> bestSellingBooks = landingPageService.getBestSellingBooks();
        model.addAttribute("books", bestSellingBooks);
        return "landing"; // file template nanti judulnya ini oke
    }
}

