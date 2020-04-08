package velin.project.atelje117.mapper.clients;

import velin.project.atelje117.model.domain.Client;
import velin.project.atelje117.viewmodels.clients.ClientViewModel;

public class ClientMapper {
    public ClientViewModel MapToViewModel(Client client){
        ClientViewModel viewModel = new ClientViewModel();
        viewModel.Id = client.getId();
        viewModel.Name = client.getName();
        viewModel.Surname = client.getSurname();
        viewModel.BirthDate = client.getBirthDate();
        viewModel.DeathDate = client.getDeathDate();
        viewModel.GraniteFigurePhotograph = client.getGraniteFigurePhotograph();
        viewModel.GranitePortraitPhotograph = client.getGranitePortraitPhotograph();
        viewModel.PorcelainPhotograph = client.getPorcelainPhotograph();
        return viewModel;
    }
}
