package velin.project.atelje117.viewmodels.orders;

import velin.project.atelje117.model.domain.PhotographAttachment;
import velin.project.atelje117.viewmodels.clients.ClientViewModel;

import java.util.Date;

public class GraniteOrderViewModel {
    public int Id;
    public Date DueTo;
    public ClientViewModel Client;
    public String Epilogue;
    public String CoworkerNote;
    public String ArtistNote;
    public String GraniteType;
    public String OrderType;
    public String Status;
    public int Price;
}
