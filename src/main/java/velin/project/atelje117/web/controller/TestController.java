package velin.project.atelje117.web.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/test")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/contentArtist")
    @PreAuthorize("hasRole('ARTIST')")
    public String artistAccess() {
        return "Artist Board.";
    }

    @GetMapping("/contentCoworker")
    @PreAuthorize("hasRole('COWORKER')")
    public String coworkerAccess() {
        return "Coworker Board.";
    }
}