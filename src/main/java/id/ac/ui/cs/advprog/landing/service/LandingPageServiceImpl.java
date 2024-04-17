package id.ac.ui.cs.advprog.landing.service;

import id.ac.ui.cs.advprog.landing.model.Book;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class LandingPageServiceImpl implements LandingPageService {

    @Override
    public List<Book> getBestSellingBooks() {
        // Sementara pakai data dummy
        return Arrays.asList(
                new Book(1L, "Book One", "/images/book1.jpg", 150),
                new Book(2L, "Book Two", "/images/book2.jpg", 120),
                new Book(3L, "Book Three", "/images/book3.jpg", 100)
        );
    }
}
