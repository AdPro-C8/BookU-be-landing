package id.ac.ui.cs.advprog.landing.model;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

//Tidak ada entity karena landing page tidak perlu menyimpan ke db
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Book yang didefinisikan di kelas ini hanya terdiri dari atribut yang dibutuhkan pada landing page seperti UUID, judul, dan foto buku
public class Book {
    private UUID id;
    private String title;
    private int downloadCount;
    private String photoUrl;

    public Book(String title, int downloadCount, String photoUrl, UUID id) {
        this.id = id;
        this.title = title;
        this.downloadCount = downloadCount;
        this.photoUrl = photoUrl;
    }
}

