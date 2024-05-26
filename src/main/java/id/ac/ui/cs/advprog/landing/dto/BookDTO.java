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
    private int downloadCount; // Included for other features' purposes
    private String photoUrl;
    private UUID id;

    public BookDTO(String title, String photoUrl, UUID id) {
        this.title = title;
        this.photoUrl = photoUrl;
        this.id = id;
    }
}
