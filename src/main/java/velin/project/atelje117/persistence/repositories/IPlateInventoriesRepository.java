package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.PlatesInventory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPlateInventoriesRepository {
    PlatesInventory getOne(int Id);
    List<PlatesInventory> findAll();
    PlatesInventory save(PlatesInventory inventory);
    void deleteById(int Id);
    void delete(PlatesInventory inventory);
    Optional<PlatesInventory> findByPlateCodeAndArtistId(String code, int artistId);
}
