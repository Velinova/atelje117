package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.MonthlyReport;
import velin.project.atelje117.persistence.repositories.IMonthlyReportsRepository;

import java.util.List;
import java.util.UUID;

public interface JpaMonthlyReportsRepository extends JpaRepository<MonthlyReport, Integer> {
   /* @Query("SELECT r FROM reports r WHERE r.artist_id = ?1")
    List<MonthlyReport> findByArtistId(UUID Id);*/
}
