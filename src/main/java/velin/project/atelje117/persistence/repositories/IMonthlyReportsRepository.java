package velin.project.atelje117.persistence.repositories;


import velin.project.atelje117.model.domain.MonthlyReport;

import java.util.List;
import java.util.UUID;

public interface IMonthlyReportsRepository {
    MonthlyReport getOne(int Id);
    List<MonthlyReport> findAll();
    MonthlyReport save(MonthlyReport report);
    void deleteById(int Id);
    void delete(MonthlyReport report);
}
