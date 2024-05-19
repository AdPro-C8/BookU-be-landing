package id.ac.ui.cs.advprog.landing.service;

import id.ac.ui.cs.advprog.landing.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//dengan adanya service ini kelas otomatis menjadi singleton
@Service
public class BookService {
    private final List<Book> books = new ArrayList<>();
    // Pada dasarnya mengapa kita tidak memerlukan repository dan Model karena LandingPage hanya mengambil data dari service lain dan tidak perlu menyimpan data tersebut
    // Data tersebut hanya perlu diringkas ulang dan ditampilkan pada front end

    //looping 5x, fetchBook diperlukan untuk mengambil data Json milik BookList dan menjadikan milik Landing
    public void fetchBook (Book book){
        if (books.size() < 5) { //data json milik adip yang mengandung seluruh atribut Buku akan diambil atribut yang diperlukan untuk landing page saja yaitu berupa nama, judul, dan UUID
            books.add(book); //iterasi selama 5x
        } else {
            throw new IllegalStateException("List already has 5 books."); //Cukup dibatasi hingga pengambilan 5 top
        }
    }
    public List<Book> getBooks(){
        return books;
    }
}
