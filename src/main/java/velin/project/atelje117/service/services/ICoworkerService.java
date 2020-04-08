package velin.project.atelje117.service.services;

import velin.project.atelje117.viewmodels.artists.ArtistBasicGridModel;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderViewModel;

import java.util.List;

public interface ICoworkerService {
    List<ArtistGridModel> getColleaguesArtists(int Id);
}
