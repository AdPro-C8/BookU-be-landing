package id.ac.ui.cs.advprog.landing.observer;

import id.ac.ui.cs.advprog.landing.service.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BestSellerObserver implements Observer {

    private final BookServiceImpl bookService;

    @Autowired
    public BestSellerObserver(BookServiceImpl bookService) {
        this.bookService = bookService;
        bookService.registerObserver(this);
    }

    @Override
    public void update() {
        System.out.println("Best selling books updated: " + bookService.getTopBooks());
    }
}
