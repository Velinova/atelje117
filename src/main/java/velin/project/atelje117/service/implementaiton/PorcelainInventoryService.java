package velin.project.atelje117.service.implementaiton;

import org.springframework.stereotype.Service;
import velin.project.atelje117.mapper.inventory.InventoryMapper;
import velin.project.atelje117.model.domain.PlatesInventory;
import velin.project.atelje117.persistence.repositories.IPlateInventoriesRepository;
import velin.project.atelje117.service.services.IPorcelainInventoryService;
import velin.project.atelje117.viewmodels.inventories.InventoryViewModel;
@Service
public class PorcelainInventoryService implements IPorcelainInventoryService {
    private final IPlateInventoriesRepository plateInventoriesRepository;
    public PorcelainInventoryService(IPlateInventoriesRepository plateInventoriesRepository){
        this.plateInventoriesRepository = plateInventoriesRepository;
    }
    public InventoryViewModel getInventory(int Id){
        InventoryMapper mapper = new InventoryMapper();
        PlatesInventory inventory = plateInventoriesRepository.getOne(Id);
        return mapper.MapToGridModel(inventory);
    }

    @Override
    public void editInventory(InventoryViewModel model) {
        PlatesInventory inventory = plateInventoriesRepository.getOne(model.Id);
        inventory.setCount(model.Stock);
        plateInventoriesRepository.save(inventory);
    }
}
