package id.ac.ui.cs.advprog.landing.service;

import id.ac.ui.cs.advprog.landing.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getTop5BooksBySales();
}
