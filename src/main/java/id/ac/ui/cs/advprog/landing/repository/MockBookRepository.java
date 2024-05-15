package id.ac.ui.cs.advprog.landing.repository;

import id.ac.ui.cs.advprog.landing.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
@Profile("dev")
public class MockBookRepository {
    public List<Book> findTop5ByOrderByTotalSalesDesc() {
        return Arrays.asList(
                new Book(UUID.randomUUID(), "Book 1", "photo1.jpg", 150, "Author 1", "Publisher 1", "Description 1", 100000.0, 10, "1234567890", 200, "Fiction", 4.5, LocalDate.of(2023, 1, 1)),
                new Book(UUID.randomUUID(), "Book 2", "photo2.jpg", 120, "Author 2", "Publisher 2", "Description 2", 90000.0, 15, "1234567891", 250, "Non-Fiction", 4.0, LocalDate.of(2020, 3, 12)),
                new Book(UUID.randomUUID(), "Book 3", "photo3.jpg", 200, "Author 2", "Publisher 1", "Description 3", 120000.0, 10, "1234567892", 500, "Education", 4.7, LocalDate.of(2024, 1, 1)),
                new Book(UUID.randomUUID(), "Book 4", "photo4.jpg", 220, "Author 3", "Publisher 3", "Description 4", 95000.0, 15, "1234567893", 275, "Self Improvement", 4.2, LocalDate.of(2012, 12, 12)),
                new Book(UUID.randomUUID(), "Book 5", "photo5.jpg", 300, "Author 4", "Publisher 4", "Description 5", 124500.0, 10, "1234567894", 300, "Culinary", 4.6, LocalDate.of(2016, 5, 19)),
                new Book(UUID.randomUUID(), "Book 6", "photo6.jpg", 80, "Author 5", "Publisher 2", "Description 6", 130000.0, 15, "1234567895", 220, "Religion", 4.9, LocalDate.of(2008, 2, 14)),
                new Book(UUID.randomUUID(), "Book 7", "photo7.jpg", 10, "Author 1", "Publisher 4", "Description 7", 300000.0, 10, "1234567896", 60, "Fiction", 4.3, LocalDate.of(2023, 10, 17)),
                new Book(UUID.randomUUID(), "Book 8", "photo8.jpg", 1200, "Author 6", "Publisher 2", "Description 8", 90000.0, 15, "1234567897", 120, "Non-Fiction", 4.0, LocalDate.of(2023, 2, 1))
        );
    }
}
