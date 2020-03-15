package velin.project.atelje117.mapper.artists;

import velin.project.atelje117.model.domain.ArtistUser;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;

public class ArtistMapper {
    public ArtistGridModel MapToGridModel(ArtistUser artist){
        ArtistGridModel gridModel = new ArtistGridModel();
        gridModel.Name = artist.getName();
        gridModel.City = artist.getCity();
        gridModel.Surname = artist.getSurname();
        
        return gridModel;
    }
}
