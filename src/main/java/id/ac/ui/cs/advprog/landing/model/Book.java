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
public class Book {
    private UUID id;
    private String title;
    private int downloadCount;
    private String photoUrl;
}
