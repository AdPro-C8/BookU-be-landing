package id.ac.ui.cs.advprog.landing.controller;

import id.ac.ui.cs.advprog.landing.service.LandingPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/landing")
public class LandingPageController {

    private final LandingPageService landingPageService;

    @Autowired
    public LandingPageController(LandingPageService landingPageService) {
        this.landingPageService = landingPageService;
    }
}
