package velin.project.atelje117.service.implementaiton;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import velin.project.atelje117.mapper.clients.ClientMapper;
import velin.project.atelje117.mapper.orders.GraniteOrderMapper;
import velin.project.atelje117.model.domain.*;
import velin.project.atelje117.persistence.repositories.IArtistsRepository;
import velin.project.atelje117.persistence.repositories.IClientsRepository;
import velin.project.atelje117.persistence.repositories.ICoworkersRepository;
import velin.project.atelje117.persistence.repositories.IGraniteOrdersRepository;
import velin.project.atelje117.service.services.IClientService;
import velin.project.atelje117.service.services.IGraniteOrderService;
import velin.project.atelje117.viewmodels.orders.GraniteOrderCreateModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderGridModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderViewModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class GraniteOrderService implements IGraniteOrderService {
    private final IGraniteOrdersRepository graniteOrdersRepository;
    private final IArtistsRepository artistsRepository;
    private final ICoworkersRepository coworkersRepository;
    private final IClientsRepository clientsRepository;
    public GraniteOrderService(IGraniteOrdersRepository graniteOrdersRepository, IClientsRepository clientsRepository,ICoworkersRepository coworkersRepository,IArtistsRepository artistsRepository){
        this.graniteOrdersRepository = graniteOrdersRepository;
        this.artistsRepository = artistsRepository;
        this.coworkersRepository = coworkersRepository;
        this.clientsRepository = clientsRepository;
    }
    @Override
    public List<GraniteOrderGridModel> getGraniteOrdersForArtist(int ArtistId) {
        GraniteOrderMapper mapper = new GraniteOrderMapper();
        List<GraniteOrderGridModel> list = new ArrayList<>();

        graniteOrdersRepository.findByArtistId(ArtistId).forEach(order -> {
            list.add(mapper.MapToGridModel(order));
        });

        return list;
    }
    @Override
    public List<GraniteOrderGridModel> getGraniteOrdersForCoworker(int CoworkerId) {
        GraniteOrderMapper mapper = new GraniteOrderMapper();
        List<GraniteOrderGridModel> list = new ArrayList<>();

        graniteOrdersRepository.findByCoworkerId(CoworkerId).forEach(order -> {
            list.add(mapper.MapToGridModel(order));
        });

        return list;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addGraniteOrder(GraniteOrderCreateModel model) {
        GraniteOrder order = new GraniteOrder();
        CoworkerUser coworker = coworkersRepository.getOne(model.CoworkerId);
//        ArtistUser artist = artistsRepository.getOne(model.ArtistId);
//        order.setArtist(artist);
        order.setCoworker(coworker);
        order.setStatus(OrderStatus.ORDERED);
        order.setOrderType(GraniteOrderType.valueOf(model.OrderType));
        order.setGraniteType(GraniteType.valueOf(model.GraniteType));
        order.setDueTo(model.DueTo);
        order.setEpilogue(model.Epilogue);
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
        graniteOrdersRepository.save(order);

    }

    @Override
    public GraniteOrderViewModel getGraniteOrderDetails(int Id) {
        GraniteOrder order = graniteOrdersRepository.getOne(Id);
        GraniteOrderMapper mapper = new GraniteOrderMapper();
        GraniteOrderViewModel viewModel = new GraniteOrderViewModel();
        viewModel = mapper.MapToViewModel(order);
        return viewModel;
    }

    @Override
    public void graniteMarkAsAccepted(GraniteOrderViewModel model) {
        GraniteOrder order = graniteOrdersRepository.getOne(model.Id);
        order.setStatus(OrderStatus.ACCEPTED);
        order.setNoteArtist(model.ArtistNote);
        order.setPrice(model.Price);
        graniteOrdersRepository.save(order);
    }

    @Override
    public void graniteMarkAsDone(int Id) {
        GraniteOrder order = graniteOrdersRepository.getOne(Id);
        order.setStatus(OrderStatus.DONE);
        graniteOrdersRepository.save(order);
    }

    @Override
    public void graniteMarkAsPaid(int Id) {
        GraniteOrder order = graniteOrdersRepository.getOne(Id);
        order.setStatus(OrderStatus.PAID);
        graniteOrdersRepository.save(order);
    }
}
