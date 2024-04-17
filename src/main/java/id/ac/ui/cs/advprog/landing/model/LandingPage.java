package id.ac.ui.cs.advprog.landing.model;


import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LandingPage {
    private Long id; // ID masih bisa digunakan untuk tujuan internal
    private String welcomeMessage; // Pesan sambutan atau deskripsi untuk halaman landas.
    private List<Book> bestSellingBooks; // Daftar buku terlaris.
}







