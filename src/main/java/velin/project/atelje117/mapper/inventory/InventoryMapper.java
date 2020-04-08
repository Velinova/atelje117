package velin.project.atelje117.mapper.inventory;

import velin.project.atelje117.model.domain.PlatesInventory;
import velin.project.atelje117.viewmodels.inventories.InventoryViewModel;

public class InventoryMapper {
    public InventoryViewModel MapToGridModel(PlatesInventory inventory){
        InventoryViewModel gridModel = new InventoryViewModel();
        gridModel.Id = inventory.getId();
        gridModel.PlateCode = inventory.getPlate().getCode();
        gridModel.PlateShape = inventory.getPlate().getShape().toString();
        gridModel.PlateDimension = inventory.getPlate().getDimension().toString();
        if(inventory.getPlate().isFramed() == true){
            gridModel.IsFramed = "yes";
        }
        else{
            gridModel.IsFramed = "no";
        }
        gridModel.Stock = inventory.getCount();
        return gridModel;
    }
}
