package velin.project.atelje117.viewmodels.coworkers;

import velin.project.atelje117.model.domain.RoleEnum;

import java.util.List;

public class CoworkerGridModel {
    public int Id;
    public String Name;
    public String Surname;
    public String City;
    public int TotalOders;
    public List<Integer> GraniteOrders;
    public List<Integer> PorcelainOrders;
}
