package velin.project.atelje117.mapper.artists;

import velin.project.atelje117.model.domain.ArtistUser;
import velin.project.atelje117.viewmodels.artists.ArtistBasicGridModel;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;

public class ArtistMapper {
    public ArtistBasicGridModel MapToBasicGridModel(ArtistUser artist){
            ArtistBasicGridModel gridModel = new ArtistBasicGridModel();
            gridModel.Name = artist.getName();
            gridModel.City = artist.getCity();
            gridModel.Email = artist.getEmail();
            gridModel.Surname = artist.getSurname();

            return gridModel;
    }
    public ArtistGridModel MapToGridModel(ArtistUser artist){
        ArtistGridModel gridModel = new ArtistGridModel();
        gridModel.Id = artist.getId();
        gridModel.Name = artist.getName();
        gridModel.Surname = artist.getSurname();
        gridModel.City = artist.getCity();
        gridModel.Email = artist.getEmail();

        return gridModel;
    }
}
