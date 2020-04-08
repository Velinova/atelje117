package velin.project.atelje117.service.services;

import lombok.Setter;
import org.springframework.stereotype.Service;
import velin.project.atelje117.viewmodels.inventories.InventoryViewModel;

@Service
public interface IPorcelainInventoryService {
    public InventoryViewModel getInventory(int Id);
    public void editInventory(InventoryViewModel model);
}
