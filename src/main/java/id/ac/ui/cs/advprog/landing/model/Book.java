package id.ac.ui.cs.advprog.landing.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Long id;
    private String title;
    private String photoUrl;
    private int salesCount;

    public Book(Long id, String title, String photoUrl, int salesCount) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
        this.salesCount = salesCount;
    }

    // Factory method buat bikin buku best seller
    public static Book createBestSellerBook(Long id, String title, String photoUrl, int salesCount) {
        return new Book(id, title, photoUrl, salesCount);
    }
}
