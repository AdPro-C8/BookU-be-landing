package id.ac.ui.cs.advprog.landing.service;
import id.ac.ui.cs.advprog.landing.observer.Subject;
import id.ac.ui.cs.advprog.landing.model.Book;
import id.ac.ui.cs.advprog.landing.observer.Observer;
import id.ac.ui.cs.advprog.landing.repository.MockBookRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService, Subject {
    private final MockBookRepository bookRepository;
    private final List<Observer> observers;
    @Getter
    private List<Book> topBooks;

    @Autowired
    public BookServiceImpl(MockBookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.observers = new ArrayList<>();
        this.topBooks = new ArrayList<>();
    }

    @Override
    public List<Book> getTop5BestSellingBooks() {
        topBooks = bookRepository.findTop5ByOrderByTotalSalesDesc();
        notifyObservers();
        return topBooks;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
