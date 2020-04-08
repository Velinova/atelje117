package velin.project.atelje117.service.implementaiton;

import org.springframework.stereotype.Service;
import velin.project.atelje117.mapper.artists.ArtistMapper;
import velin.project.atelje117.mapper.coworkers.CoworkerMapper;
import velin.project.atelje117.mapper.inventory.InventoryMapper;
import velin.project.atelje117.mapper.orders.GraniteOrderMapper;
import velin.project.atelje117.mapper.orders.PorcelainOrderMapper;
import velin.project.atelje117.model.domain.*;
import velin.project.atelje117.persistence.repositories.IArtistsRepository;
import velin.project.atelje117.persistence.repositories.ICoworkersRepository;
import velin.project.atelje117.persistence.repositories.IPlateInventoriesRepository;
import velin.project.atelje117.persistence.repositories.IPorcelainPlatesRepository;
import velin.project.atelje117.service.services.IArtistService;
import velin.project.atelje117.viewmodels.artists.ArtistBasicGridModel;
import velin.project.atelje117.viewmodels.coworkers.CoworkerGridModel;
import velin.project.atelje117.viewmodels.inventories.CreateInventoryViewModel;
import velin.project.atelje117.viewmodels.inventories.InventoryViewModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderGridModel;

import java.util.*;

@Service
public class ArtistService implements IArtistService {
    private final IArtistsRepository artistsRepository;
    private final ICoworkersRepository coworkersRepository;
    private final IPorcelainPlatesRepository porcelainPlatesRepository;
    private final IPlateInventoriesRepository plateInventoriesRepository;
    public ArtistService(IArtistsRepository artistsRepository, ICoworkersRepository coworkersRepository
    ,IPorcelainPlatesRepository porcelainPlatesRepository, IPlateInventoriesRepository plateInventoriesRepository
    ){
        this.artistsRepository = artistsRepository;
        this.coworkersRepository = coworkersRepository;
        this.porcelainPlatesRepository = porcelainPlatesRepository;
        this.plateInventoriesRepository = plateInventoriesRepository;
    }

    @Override
    public List<ArtistBasicGridModel> getAll() {
        ArtistMapper mapper = new ArtistMapper();
        List<ArtistBasicGridModel> list = new ArrayList<ArtistBasicGridModel>();

         artistsRepository.findAll().forEach(artist -> {
             list.add(mapper.MapToBasicGridModel(artist));
         });

         return list;
}


    @Override
    public List<InventoryViewModel> getInventory(int Id) {
        InventoryMapper mapper = new InventoryMapper();
        List<InventoryViewModel> list = new ArrayList<>();

        artistsRepository.getInventory(Id).forEach(inventory -> {
            list.add(mapper.MapToGridModel(inventory));
        });
        return list;
    }

    @Override
    public void addCoworker(int artistId, int coworkerId) {
        ArtistUser artist = artistsRepository.getOne(artistId);
        CoworkerUser coworker  =  coworkersRepository.getOne(coworkerId);
        Collection<CoworkerUser> coworkers = artist.getCoworkers();
        coworkers.add(coworker);
        artist.setCoworkers((Set<CoworkerUser>)coworkers);
        artistsRepository.save(artist);
    }

    @Override
    public void deleteCoworker(int artistId, int coworkerId) {
        ArtistUser artist = artistsRepository.getOne(artistId);
        CoworkerUser coworker  =  coworkersRepository.getOne(coworkerId);
        Collection<CoworkerUser> coworkers = artist.getCoworkers();
        coworkers.remove(coworker);
        artist.setCoworkers((Set<CoworkerUser>)coworkers);
        artistsRepository.save(artist);
    }

    @Override
    public int addInventory(CreateInventoryViewModel model) {
        String code = model.Plate.Code;
        int artistId = model.ArtistId;
        ArtistUser artist = artistsRepository.getOne(artistId);
        PorcelainPlate plate = porcelainPlatesRepository.getOne(code);
        PlatesInventory newInventory = new PlatesInventory();
        if(plate != null){
            newInventory.setPlate(plate);
            newInventory.setCount(model.Stock);
            newInventory.setArtist(artist);

        }else{
            PorcelainPlate newPlate = new PorcelainPlate();
            newPlate.setCode(model.Plate.Code);
            newPlate.setDimension(PlateDimension.valueOf(model.Plate.Dimension.toUpperCase()));
            newPlate.setFramed(model.Plate.IsFramed);
            newPlate.setShape(PlateShape.valueOf(model.Plate.Shape.toUpperCase()));
            newInventory.setArtist(artist);
            newInventory.setCount(model.Stock);
            newInventory.setPlate(newPlate);

        }
        Set<PlatesInventory> inventories = artist.getInventories();
        inventories.add(newInventory);
        artist.setInventories(inventories);
        return newInventory.getId();
    }


    @Override
    public List<CoworkerGridModel> getCoworkers(int Id) {
        CoworkerMapper mapper = new CoworkerMapper();
        List<CoworkerGridModel> list = new ArrayList<>();

        artistsRepository.getOne(Id).getCoworkers().forEach(coworker -> {
            list.add(mapper.MapToGridModel(coworker));
        });

        return list;
    }
}
