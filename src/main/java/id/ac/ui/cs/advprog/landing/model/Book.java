package id.ac.ui.cs.advprog.landing.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Book {
    private Long id; // ID untuk tujuan internal atau referensi
    private String title; // Judul buku
    private String photoUrl; // URL foto buku
    private int salesCount; // Jumlah penjualan buku

    public Book(Long id, String title, String photoUrl, int salesCount) {
        this.id = id;
        this.title = title;
        this.photoUrl = photoUrl;
        this.salesCount = salesCount;
    }
}




