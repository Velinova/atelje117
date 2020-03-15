package velin.project.atelje117.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import velin.project.atelje117.service.services.IArtistService;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;

import java.util.List;

@RestController
public class ArtistController {
    private IArtistService artistService;

    public ArtistController(IArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artist")
    @CrossOrigin(origins = "http://localhost:8080")
    public List<ArtistGridModel> getArtists() {
        return artistService.getAll();
    }
}
