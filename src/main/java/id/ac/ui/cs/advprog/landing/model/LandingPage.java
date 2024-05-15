package id.ac.ui.cs.advprog.landing.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class LandingPage {
    private String title;
    private String photoUrl;
    private int salesCount;
}
