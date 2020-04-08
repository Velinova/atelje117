package velin.project.atelje117.service.services;

import velin.project.atelje117.model.domain.PorcelainOrder;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderCreateModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderViewModel;

import java.util.List;

public interface IPorcelainOrderService {
    PorcelainOrderViewModel getPorcelainOrderDetails(int Id);
    void porcelainMarkAsAccepted(PorcelainOrderViewModel model, int ArtistId);
    void porcelainMarkAsDone(int Id);
    void porcelainMarkAsPaid(int Id);
    List<PorcelainOrderGridModel> getPorcelainOrdersForArtist(int Id);
    List<PorcelainOrderGridModel> getPorcelainOrdersForCoworker(int Id);
    void addPorcelainOrder(PorcelainOrderCreateModel model);
}
