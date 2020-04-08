package velin.project.atelje117.mapper.coworkers;

import velin.project.atelje117.model.domain.*;
import velin.project.atelje117.viewmodels.coworkers.CoworkerGridModel;

public class CoworkerMapper {
    public CoworkerGridModel MapToGridModel(CoworkerUser coworker){
        CoworkerGridModel gridModel = new CoworkerGridModel();
        gridModel.Id = coworker.getId();
        gridModel.Name = coworker.getName();
        gridModel.Surname = coworker.getSurname();
        gridModel.City = coworker.getCity();
        gridModel.TotalOders = coworker.getGraniteOrders().size() + coworker.getPorcelainOrders().size();
        int countGraniteOrdered = 0;
        int countGraniteAccepted = 0;
        int countGraniteDone = 0;
        int countPorcelainOrdered = 0;
        int countPorcelainAccepted = 0;
        int countPorcelainDone = 0;
        for (GraniteOrder g: coworker.getGraniteOrders()
             ) {
            if(g.getStatus().equals(OrderStatus.ACCEPTED)){
                countGraniteAccepted++;
            }
            if(g.getStatus().equals(OrderStatus.DONE)){
                countGraniteDone++;
            }
            if(g.getStatus().equals(OrderStatus.ORDERED)){
                countGraniteOrdered++;
            }
        }
        gridModel.GraniteOrders.add(countGraniteOrdered);
        gridModel.GraniteOrders.add(countGraniteAccepted);
        gridModel.GraniteOrders.add(countGraniteDone);
        for (PorcelainOrder g: coworker.getPorcelainOrders()
        ) {
            if(g.getStatus().equals(OrderStatus.ACCEPTED)){
                countPorcelainAccepted++;
            }
            if(g.getStatus().equals(OrderStatus.DONE)){
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
}
