package velin.project.atelje117.viewmodels.coworkers;

import velin.project.atelje117.model.domain.RoleEnum;

import java.util.ArrayList;
import java.util.List;

public class CoworkerGridModel {
    public int Id;
    public String Name;
    public String Surname;
    public String City;
    public int TotalOrders;
    public List<Integer> GraniteOrders = new ArrayList<>();
    public List<Integer> PorcelainOrders = new ArrayList<>();
}
