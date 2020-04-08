package velin.project.atelje117.service.services;

import velin.project.atelje117.viewmodels.artists.ArtistBasicGridModel;
import velin.project.atelje117.viewmodels.coworkers.CoworkerGridModel;
import velin.project.atelje117.viewmodels.inventories.CreateInventoryViewModel;
import velin.project.atelje117.viewmodels.inventories.InventoryViewModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderGridModel;

import java.util.List;

public interface IArtistService {
    List<ArtistBasicGridModel> getAll();
    List<CoworkerGridModel> getCoworkers(int Id);
    List<InventoryViewModel> getInventory(int Id);
    void addCoworker(int artistId, int coworkerId);
    void deleteCoworker(int artistId, int coworkerId);
    int addInventory(CreateInventoryViewModel model);
}
