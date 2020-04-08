package velin.project.atelje117.persistence.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import velin.project.atelje117.model.domain.CoworkerUser;

import java.util.List;

public interface ICoworkersRepository {
    CoworkerUser getOne(int Id);
    List<CoworkerUser> findAll();
    CoworkerUser save(CoworkerUser coworker);
    void deleteById(int Id);
    void delete(CoworkerUser coworker);
    @Query("select SUM(go.price) FROM granite_orders go WHERE status = 'DONE' AND artist_id=?1 AND coworker_id = ?2")
    int getUnpaidAmount(int ArtistId, int CoworkerId);
}
