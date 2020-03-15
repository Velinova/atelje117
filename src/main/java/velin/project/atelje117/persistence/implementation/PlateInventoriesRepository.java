package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.PlatesInventory;
import velin.project.atelje117.persistence.jpa.JpaPlateInventoriesRepository;
import velin.project.atelje117.persistence.repositories.IPlateInventoriesRepository;

import java.util.List;
import java.util.UUID;

@Repository
public class PlateInventoriesRepository implements IPlateInventoriesRepository {
    private final JpaPlateInventoriesRepository repository;

    public PlateInventoriesRepository(JpaPlateInventoriesRepository repository){
        this.repository = repository;
    }

    @Override
    public PlatesInventory getOne(int Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<PlatesInventory> findAll() {
        return this.repository.findAll();
    }

    @Override
    public PlatesInventory save(PlatesInventory inventory) {
        return this.repository.save(inventory);
    }

    @Override
    public void deleteById(int Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public void delete(PlatesInventory inventory) {
        this.repository.delete(inventory);
    }

    /*@Override
    public List<PlatesInventory> findByArtistId(UUID Id) {
        return this.findByArtistId(Id);
    }*/
}
