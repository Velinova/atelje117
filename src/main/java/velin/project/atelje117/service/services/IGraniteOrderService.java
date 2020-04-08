package velin.project.atelje117.service.services;

import velin.project.atelje117.viewmodels.orders.GraniteOrderCreateModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderGridModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderViewModel;

import java.util.List;

public interface IGraniteOrderService {
    public GraniteOrderViewModel getGraniteOrderDetails(int Id);
    public void graniteMarkAsAccepted(GraniteOrderViewModel model);
    public void graniteMarkAsDone(int Id);
    public void graniteMarkAsPaid(int Id);
    public List<GraniteOrderGridModel> getGraniteOrdersForArtist(int ArtistId);
    public List<GraniteOrderGridModel> getGraniteOrdersForCoworker(int CoworkerId);
    public void addGraniteOrder(GraniteOrderCreateModel model);
}
