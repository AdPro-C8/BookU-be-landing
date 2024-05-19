package id.ac.ui.cs.advprog.landing.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//Book yang didefinisikan di kelas ini hanya terdiri dari atribut yang dibutuhkan pada landing page seperti UUID, judul, dan foto buku
public class Book {
    private UUID id;
    private String title;
    private String photoUrl;

}
