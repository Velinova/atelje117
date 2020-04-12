package velin.project.atelje117.mapper.coworkers;

import velin.project.atelje117.model.domain.*;
import velin.project.atelje117.viewmodels.coworkers.CoworkerGridModel;
import velin.project.atelje117.viewmodels.coworkers.CoworkerViewModel;

import java.util.ArrayList;
import java.util.List;

public class CoworkerMapper {
    public CoworkerGridModel MapToGridModel(CoworkerUser coworker){
        CoworkerGridModel gridModel = new CoworkerGridModel();
        gridModel.Id = coworker.getId();
        gridModel.Name = coworker.getName();
        gridModel.Surname = coworker.getSurname();
        gridModel.City = coworker.getCity();
        gridModel.TotalOrders = coworker.getGraniteOrders().size() + coworker.getPorcelainOrders().size();
        int countGraniteOrdered = 0;
        int countGraniteAccepted = 0;
        int countGraniteDone = 0;
        int countPorcelainOrdered = 0;
        int countPorcelainAccepted = 0;
        int countPorcelainDone = 0;
        List<GraniteOrder> graniteOrders = coworker.getGraniteOrders();
        for(int i =0 ; i< graniteOrders.size(); i++){
            if(graniteOrders.get(i).getStatus().toString()=="ACCEPTED"){
                countGraniteAccepted++;
            }
            if((graniteOrders.get(i).getStatus().toString()=="DONE")||(graniteOrders.get(i).getStatus().toString()=="PAID")){
                countGraniteDone++;
            }
            if (graniteOrders.get(i).getStatus().toString()=="ORDERED"){
                countGraniteOrdered++;
            }
        }
        gridModel.GraniteOrders.add(countGraniteOrdered);
        gridModel.GraniteOrders.add(countGraniteAccepted);
        gridModel.GraniteOrders.add(countGraniteDone);
        for (PorcelainOrder g: coworker.getPorcelainOrders()
        ) {
            if(g.getStatus().toString()=="ACCEPTED"){
                countPorcelainAccepted++;
            }
            if((g.getStatus().toString()=="DONE")||( g.getStatus().toString()=="ORDERED")){
                countPorcelainDone++;
            }
            if(g.getStatus().equals(OrderStatus.ORDERED)){
                countPorcelainOrdered++;
            }
        }
        gridModel.PorcelainOrders.add(countPorcelainOrdered);
        gridModel.PorcelainOrders.add(countPorcelainAccepted);
        gridModel.PorcelainOrders.add(countPorcelainDone);
        return gridModel;
    }
    public CoworkerViewModel MapToViewModel(CoworkerUser coworker){
        CoworkerViewModel viewModel = new CoworkerViewModel();
        viewModel.Id = coworker.getId();
        viewModel.Name = coworker.getName();
        viewModel.Surname = coworker.getSurname();
        viewModel.City = coworker.getCity();

        return viewModel;
    }
}
