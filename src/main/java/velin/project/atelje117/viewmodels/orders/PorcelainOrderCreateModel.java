package velin.project.atelje117.viewmodels.orders;

import velin.project.atelje117.viewmodels.clients.ClientViewModel;

import java.util.Date;

public class PorcelainOrderCreateModel {
    public int ArtistId;
    public int CoworkerId;
    public ClientViewModel Client;
    public Date DueTo;
    public String ColorType;
    public String PlateCode;
    public String CoworkerNote;
}
