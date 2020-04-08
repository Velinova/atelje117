package velin.project.atelje117.service.implementaiton;

import org.springframework.stereotype.Service;
import velin.project.atelje117.mapper.orders.PorcelainOrderMapper;
import velin.project.atelje117.model.domain.*;
import velin.project.atelje117.persistence.repositories.*;
import velin.project.atelje117.service.services.IPorcelainOrderService;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderCreateModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class PorcelainOrderService implements IPorcelainOrderService {
    public final IPorcelainOrdersRepository porcelainOrdersRepository;
    public final IPlateInventoriesRepository plateInventoriesRepository;
    private final IArtistsRepository artistsRepository;
    private final ICoworkersRepository coworkersRepository;
    private final IClientsRepository clientsRepository;
    private final IPorcelainPlatesRepository porcelainPlatesRepository;

    public PorcelainOrderService(IPorcelainPlatesRepository porcelainPlatesRepository,IClientsRepository clientsRepository, IArtistsRepository artistsRepository, ICoworkersRepository coworkersRepository, IPorcelainOrdersRepository porcelainOrdersRepository,IPlateInventoriesRepository plateInventoriesRepository){
        this.porcelainOrdersRepository = porcelainOrdersRepository;
        this.plateInventoriesRepository = plateInventoriesRepository;
        this.artistsRepository = artistsRepository;
        this.coworkersRepository = coworkersRepository;
        this.clientsRepository = clientsRepository;
        this.porcelainPlatesRepository = porcelainPlatesRepository;
    }
    @Override
    public PorcelainOrderViewModel getPorcelainOrderDetails(int Id) {
        PorcelainOrder order = porcelainOrdersRepository.getOne(Id);
        PorcelainOrderMapper mapper = new PorcelainOrderMapper();
        PorcelainOrderViewModel viewModel = new PorcelainOrderViewModel();
        viewModel = mapper.MapToViewModel(order);
        return viewModel;
    }

    @Override
    public void porcelainMarkAsAccepted(PorcelainOrderViewModel model, int ArtistId) {
        PorcelainOrder order = porcelainOrdersRepository.getOne(model.Id);
        order.setStatus(OrderStatus.ACCEPTED);
        order.setNoteArtist(model.ArtistNote);
        order.setPrice(model.Price);
        PlatesInventory inventory = plateInventoriesRepository.findByPlateCodeAndArtistId(order.getPlateCode(), ArtistId).get();
        inventory.setCount(inventory.getCount()-1);
        plateInventoriesRepository.save(inventory);
        porcelainOrdersRepository.save(order);
    }

    @Override
    public void porcelainMarkAsDone(int Id) {
        PorcelainOrder order = porcelainOrdersRepository.getOne(Id);
        order.setStatus(OrderStatus.DONE);
        porcelainOrdersRepository.save(order);
    }

    @Override
    public void porcelainMarkAsPaid(int Id) {
        PorcelainOrder order = porcelainOrdersRepository.getOne(Id);
        order.setStatus(OrderStatus.PAID);
        porcelainOrdersRepository.save(order);
    }

    @Override
    public List<PorcelainOrderGridModel> getPorcelainOrdersForArtist(int ArtistId) {
        PorcelainOrderMapper mapper = new PorcelainOrderMapper();
        List<PorcelainOrderGridModel> list = new ArrayList<>();

        porcelainOrdersRepository.findByArtistId(ArtistId).forEach(order -> {
            list.add(mapper.MapToGridModel(order));
        });

        return list;
    }

    @Override
    public List<PorcelainOrderGridModel> getPorcelainOrdersForCoworker(int CoworkerId) {
        PorcelainOrderMapper mapper = new PorcelainOrderMapper();
        List<PorcelainOrderGridModel> list = new ArrayList<>();

        porcelainOrdersRepository.findByCoworkerId(CoworkerId).forEach(order -> {
            list.add(mapper.MapToGridModel(order));
        });

        return list;
    }
    @Override
    public void addPorcelainOrder(PorcelainOrderCreateModel model) {
        PorcelainOrder order = new PorcelainOrder();
        ArtistUser artist = artistsRepository.getOne(model.ArtistId);
        CoworkerUser coworker = coworkersRepository.getOne(model.CoworkerId);
        order.setArtist(artist);
        order.setCoworker(coworker);
        order.setStatus(OrderStatus.ORDERED);
        order.setColorType(ColorType.valueOf(model.ColorType));
        order.setPlateCode(model.PlateCode);
        order.setDueTo(model.DueTo);
        order.setNoteCoworker(model.CoworkerNote);
        Client client = new Client();
        client.setName(model.Client.Name);
        client.setSurname(model.Client.Surname);
        client.setBirthDate(model.Client.BirthDate);
        client.setDeathDate(model.Client.DeathDate);
        client.setGraniteFigurePhotograph(model.Client.GraniteFigurePhotograph);
        client.setGranitePortraitPhotograph(model.Client.GranitePortraitPhotograph);
        order.setClient(client);
        clientsRepository.save(client);
        porcelainOrdersRepository.save(order);

    }
}
