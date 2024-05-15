package id.ac.ui.cs.advprog.landing.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Book {
    private UUID id;
    private String title;
    private String photoUrl;
    private int salesCount;
    private String author;
    private String publisher;
    private String description;
    private double price;
    private int stock;
    private String isbn;
    private int numberOfPages;
    private String category;
    private double rating;
    private LocalDate publicationDate;
}
