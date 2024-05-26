package id.ac.ui.cs.advprog.landing.service;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface BookService {
    CompletableFuture<List<BookDTO>> getBestSellers();
}
