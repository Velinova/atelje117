package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.exceptions.ObjectNotFoundException;
import velin.project.atelje117.model.domain.MonthlyReport;
import velin.project.atelje117.persistence.jpa.JpaMonthlyReportsRepository;
import velin.project.atelje117.persistence.repositories.IMonthlyReportsRepository;

import java.util.List;
import java.util.UUID;

@Repository
public class MonthlyReportsRepository implements IMonthlyReportsRepository {
    private final JpaMonthlyReportsRepository repository;

    public MonthlyReportsRepository(JpaMonthlyReportsRepository repository){
        this.repository = repository;
    }

    @Override
    public MonthlyReport getOne(int Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<MonthlyReport> findAll() {
        return this.repository.findAll();
    }

    @Override
    public MonthlyReport save(MonthlyReport report) {
        return this.repository.save(report);
    }


    @Override
    public void deleteById(int Id) {

    }

    @Override
    public void delete(MonthlyReport report) {

    }
}
