package velin.project.atelje117.mapper.plates;

import velin.project.atelje117.model.domain.PorcelainPlate;
import velin.project.atelje117.viewmodels.plates.PorcelainPlateViewModel;

public class PlateMapper {
    public PorcelainPlateViewModel MapToViewModel(PorcelainPlate plate){
        PorcelainPlateViewModel viewModel = new PorcelainPlateViewModel();
        viewModel.Code = plate.getCode();
        viewModel.Shape = plate.getShape().toString();
        viewModel.Dimension = plate.getDimension().toString();
        viewModel.IsFramed = plate.isFramed();
        return viewModel;
    }
}
