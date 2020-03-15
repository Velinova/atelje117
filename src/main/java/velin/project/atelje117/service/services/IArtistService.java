package velin.project.atelje117.service.services;

import velin.project.atelje117.model.domain.ArtistUser;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;

import java.util.List;

public interface IArtistService {
    List<ArtistGridModel> getAll();
    ArtistUser registerArtist(ArtistUser artist);
    ArtistUser logInArtist(String username, String password);
}
