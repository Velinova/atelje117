package velin.project.atelje117.viewmodels.orders;

import velin.project.atelje117.model.domain.PorcelainPlate;
import velin.project.atelje117.viewmodels.clients.ClientViewModel;
import velin.project.atelje117.viewmodels.plates.PorcelainPlateViewModel;

import java.util.Date;

public class PorcelainOrderViewModel {
    public int Id;
    public Date DueTo;
    public ClientViewModel Client;
    public String CoworkerNote;
    public String ArtistNote;
    public String ColorType;
    public String PlateCode;
    public String Status;
    public int Price;
}
