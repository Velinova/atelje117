package velin.project.atelje117.web.controller;

import org.springframework.web.bind.annotation.*;
import velin.project.atelje117.service.services.*;
import velin.project.atelje117.viewmodels.artists.ArtistGridModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderCreateModel;
import velin.project.atelje117.viewmodels.orders.GraniteOrderGridModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderCreateModel;
import velin.project.atelje117.viewmodels.orders.PorcelainOrderGridModel;

import java.util.List;

@RestController
@RequestMapping("/coworker")
@CrossOrigin(origins = "http://localhost:8080")
public class CoworkerController {
    private ICoworkerService coworkerService;
    private IGraniteOrderService graniteOrderService;
    private IPorcelainOrderService porcelainOrderService;
    public CoworkerController(ICoworkerService coworkerService,IGraniteOrderService graniteOrderService,IPorcelainOrderService porcelainOrderService){
        this.coworkerService = coworkerService;
        this.graniteOrderService = graniteOrderService;
        this.porcelainOrderService = porcelainOrderService;
    }

    @GetMapping("/getColleagues")
    public List<ArtistGridModel> getColleaguesArtists(@RequestParam int id){
        return coworkerService.getColleaguesArtists(id);
    }
    @GetMapping("/getGraniteOrders")
    public List<GraniteOrderGridModel> getGraniteOrders(@RequestParam int Id){
        return graniteOrderService.getGraniteOrdersForCoworker(Id);
    }
    @GetMapping("/getPorcelainOrders")
    public List<PorcelainOrderGridModel> getPorcelainOrders(@RequestParam int Id){
        return porcelainOrderService.getPorcelainOrdersForCoworker(Id);
    }

    @PostMapping("/graniteMarkAsPaid")
    public void graniteMarkAsPaid(@RequestParam int Id){
        graniteOrderService.graniteMarkAsPaid(Id);
    }

    @PostMapping("/createGraniteOrder")
    public void addGraniteOrder(GraniteOrderCreateModel model){
        graniteOrderService.addGraniteOrder(model);
    }
    @PostMapping("/createPorcelainOrder")
    public void addPorcelainOrder(PorcelainOrderCreateModel model){
        porcelainOrderService.addPorcelainOrder(model);
    }
}

//    @PostMapping("/graniteMarkAsAccepted")
//    public void graniteMarkAsAccepted(@RequestBody GraniteOrderViewModel model){
//        graniteOrderService.graniteMarkAsAccepted(model);
//    }
//
//    @PostMapping("/graniteMarkAsDone")
//    public void graniteMarkAsDone(@RequestParam int Id){
//        graniteOrderService.graniteMarkAsDone(Id);
//    }
//
//    //porcelain orders
//    @GetMapping("/getPorcelainOrders")
//    public List<PorcelainOrderGridModel> getPorcelainOrders(@RequestParam int Id){
//        return artistService.getPorcelainOrders(Id);
//    }
//
//    @GetMapping("/getPorcelainOrderDetails")
//    public PorcelainOrderViewModel getPorcelainOrderDetails(@RequestParam int Id){
//        return porcelainOrderService.getPorcelainOrderDetails(Id);
//    }
//
//    @GetMapping("/porcelainMarkAsAccepted")
//    public PorcelainOrderViewModel porcelainMarkAsAccepted(@RequestParam int Id){
//        return porcelainOrderService.getPorcelainOrderDetails(Id);
//    }
//
//    @PostMapping("/porcelainMarkAsAccepted")
//    public void porcelainMarkAsAccepted(@RequestBody PorcelainOrderViewModel model, @RequestBody int ArtistId){
//        porcelainOrderService.porcelainMarkAsAccepted(model, ArtistId);
//    }
//
//    @PostMapping("/porcelainMarkAsDone")
//    public void porcelainMarkAsDone(@RequestParam int Id){
//        porcelainOrderService.porcelainMarkAsDone(Id);
//    }
//}
