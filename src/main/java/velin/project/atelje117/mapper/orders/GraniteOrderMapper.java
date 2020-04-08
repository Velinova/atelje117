package velin.project.atelje117.mapper.orders;

import velin.project.atelje117.mapper.clients.ClientMapper;
import velin.project.atelje117.mapper.plates.PlateMapper;
import velin.project.atelje117.model.domain.GraniteOrder;
import velin.project.atelje117.viewmodels.orders.GraniteOrderViewModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderGridModel;

public class GraniteOrderMapper {
    public GraniteOrderGridModel MapToGridModel(GraniteOrder order) {
        GraniteOrderGridModel gridModel = new GraniteOrderGridModel();
        gridModel.Id = order.getId();
        gridModel.CoworkerName = order.getCoworker().getName() + order.getCoworker().getSurname();
        gridModel.DueTo = order.getDueTo().toString();
        gridModel.OrderType = order.getOrderType().toString();
        gridModel.GraniteType = order.getGraniteType().toString();
        gridModel.Status = order.getStatus().toString();
        gridModel.Price = order.getPrice();
        return gridModel;
    }
    public GraniteOrderViewModel MapToViewModel(GraniteOrder order){
        ClientMapper clientMapper = new ClientMapper();
        GraniteOrderViewModel viewModel = new GraniteOrderViewModel();
        viewModel.Id = order.getId();
        viewModel.DueTo = order.getDueTo();
        viewModel.Client = clientMapper.MapToViewModel(order.getClient());
        viewModel.ArtistNote = order.getNoteArtist();
        viewModel.CoworkerNote = order.getNoteCoworker();
        viewModel.Epilogue = order.getEpilogue();
        viewModel.GraniteType = order.getGraniteType().toString();
        viewModel.OrderType = order.getOrderType().toString();
        viewModel.Status = order.getStatus().toString();
        viewModel.Price = order.getPrice();
        return viewModel;
    }
}
