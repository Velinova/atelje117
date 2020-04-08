package velin.project.atelje117.mapper.orders;

import velin.project.atelje117.mapper.clients.ClientMapper;
import velin.project.atelje117.mapper.plates.PlateMapper;
import velin.project.atelje117.model.domain.PorcelainOrder;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderViewModel;
import velin.project.atelje117.viewmodels.plates.PorcelainPlateViewModel;

public class PorcelainOrderMapper {
    public PorcelainOrderGridModel MapToGridModel(PorcelainOrder order){
        PorcelainOrderGridModel gridModel = new PorcelainOrderGridModel();
        gridModel.Id = order.getId();
        gridModel.DueTo = order.getDueTo().toString();
        gridModel.ColorType = order.getColorType().toString();
        gridModel.CoworkerName = order.getCoworker().getName() + order.getCoworker().getSurname();
        gridModel.PlateCode = order.getPlateCode();
        gridModel.Status = order.getStatus().toString();
        gridModel.Price = order.getPrice();
        return gridModel;
    }

    public PorcelainOrderViewModel MapToViewModel(PorcelainOrder order){
        ClientMapper clientMapper = new ClientMapper();
        PlateMapper plateMapper = new PlateMapper();
        PorcelainOrderViewModel viewModel = new PorcelainOrderViewModel();
        viewModel.Id = order.getId();
        viewModel.DueTo = order.getDueTo();
        viewModel.Client = clientMapper.MapToViewModel(order.getClient());
        viewModel.ArtistNote = order.getNoteArtist();
        viewModel.CoworkerNote = order.getNoteCoworker();
        viewModel.ColorType = order.getColorType().toString();
        viewModel.PlateCode = order.getPlateCode();
        viewModel.Status = order.getStatus().toString();
        viewModel.Price = order.getPrice();
        return viewModel;
    }
}
