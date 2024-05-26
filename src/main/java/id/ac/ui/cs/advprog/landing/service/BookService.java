package id.ac.ui.cs.advprog.landing.service;
import id.ac.ui.cs.advprog.landing.dto.BookDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface BookService {
    List<BookDTO> getBestSellers();
}