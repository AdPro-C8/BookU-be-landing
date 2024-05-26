package id.ac.ui.cs.advprog.landing.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor

public class BookDTO {
    private String title;
    private int downloadCount;
    private String photoUrl;
    private UUID id;
    private int rating;

    public BookDTO(String title, int downloadCount, String photoUrl, UUID id, int rating) {
        this.title = title;
        this.downloadCount = downloadCount;
        this.photoUrl = photoUrl;
        this.id = id;
        this.rating = rating;
    }
}