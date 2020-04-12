package velin.project.atelje117.web.controller;

import org.springframework.web.bind.annotation.*;
import velin.project.atelje117.service.services.IArtistService;
import velin.project.atelje117.service.services.IGraniteOrderService;
import velin.project.atelje117.service.services.IPorcelainInventoryService;
import velin.project.atelje117.service.services.IPorcelainOrderService;
import velin.project.atelje117.viewmodels.artists.ArtistBasicGridModel;
import velin.project.atelje117.viewmodels.coworkers.CoworkerGridModel;
import velin.project.atelje117.viewmodels.inventories.CreateInventoryViewModel;
import velin.project.atelje117.viewmodels.inventories.InventoryViewModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderViewModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderViewModel;

import java.util.List;

@RestController
@RequestMapping("/artist")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ArtistController {
    private IArtistService artistService;
    private IPorcelainInventoryService porcelainInventoryService;
    private IGraniteOrderService graniteOrderService;
    private IPorcelainOrderService porcelainOrderService;
    public ArtistController(IArtistService artistService, IPorcelainInventoryService porcelainInventoryService, IGraniteOrderService graniteOrderService, IPorcelainOrderService porcelainOrderService) {
        this.artistService = artistService;
        this.porcelainInventoryService = porcelainInventoryService;
        this.graniteOrderService = graniteOrderService;
        this.porcelainOrderService = porcelainOrderService;
    }

    @GetMapping("/get")
    public List<ArtistBasicGridModel> getArtists() {
        return artistService.getAll();
    }

    //coworkers
    @GetMapping("/getCoworkers/{id}")
    public List<CoworkerGridModel> getCoworkers(@PathVariable int id){
        return artistService.getCoworkers(id);
    }

    @GetMapping("/addCoworker/{artistId}/{coworkerId}")
    public void addCoworker(@PathVariable int artistId, @PathVariable int coworkerId){
        artistService.addCoworker(artistId, coworkerId);
    }

    @GetMapping("/deleteCoworker/{artistId}/{coworkerId}")
    public void deleteCoworker(@PathVariable int artistId, @PathVariable int coworkerId){
        artistService.deleteCoworker(artistId, coworkerId);
    }

    //inventories
    @GetMapping("/getInventory")
    public List<InventoryViewModel> getInventory(@RequestParam int Id){
        return artistService.getInventory(Id);
    }

    @PostMapping("/addInventory")
    public int addInventory(@RequestBody CreateInventoryViewModel model){
        return artistService.addInventory(model);
    }

    @GetMapping("/editInventory")
    public InventoryViewModel editInventory( @RequestParam int Id){
        return porcelainInventoryService.getInventory(Id);
    }

    @PostMapping("/editInventory")
    public void editInventory( @RequestBody InventoryViewModel model){
         porcelainInventoryService.editInventory(model);
    }

    //granite orders
    @GetMapping("/getGraniteOrders")
    public List<GraniteOrderGridModel> getGraniteOrders(@RequestParam int Id){
        return graniteOrderService.getGraniteOrdersForArtist(Id);
    }

    @GetMapping("/getGraniteOrderDetails")
    public GraniteOrderViewModel getGraniteOrderDetails(@RequestParam int Id){
        return graniteOrderService.getGraniteOrderDetails(Id);
    }

    @GetMapping("/graniteMarkAsAccepted")
    public GraniteOrderViewModel graniteMarkAsAccepted(@RequestParam int Id){
        return graniteOrderService.getGraniteOrderDetails(Id);
    }

    @PostMapping("/graniteMarkAsAccepted")
    public void graniteMarkAsAccepted(@RequestBody GraniteOrderViewModel model){
         graniteOrderService.graniteMarkAsAccepted(model);
    }

    @PostMapping("/graniteMarkAsDone")
    public void graniteMarkAsDone(@RequestParam int Id){
        graniteOrderService.graniteMarkAsDone(Id);
    }

    //porcelain orders
    @GetMapping("/getPorcelainOrders")
    public List<PorcelainOrderGridModel> getPorcelainOrders(@RequestParam int Id){
        return porcelainOrderService.getPorcelainOrdersForArtist(Id);
    }

    @GetMapping("/getPorcelainOrderDetails")
    public PorcelainOrderViewModel getPorcelainOrderDetails(@RequestParam int Id){
        return porcelainOrderService.getPorcelainOrderDetails(Id);
    }

    @GetMapping("/porcelainMarkAsAccepted")
    public PorcelainOrderViewModel porcelainMarkAsAccepted(@RequestParam int Id){
        return porcelainOrderService.getPorcelainOrderDetails(Id);
    }

    @PostMapping("/porcelainMarkAsAccepted")
    public void porcelainMarkAsAccepted(@RequestBody PorcelainOrderViewModel model, @RequestBody int ArtistId){
        porcelainOrderService.porcelainMarkAsAccepted(model, ArtistId);
    }

    @PostMapping("/porcelainMarkAsDone")
    public void porcelainMarkAsDone(@RequestParam int Id){
        porcelainOrderService.porcelainMarkAsDone(Id);
    }
}
