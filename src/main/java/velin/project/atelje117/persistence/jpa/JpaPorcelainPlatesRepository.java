package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.PorcelainPlate;
import velin.project.atelje117.persistence.repositories.ICoworkersRepository;

public interface JpaPorcelainPlatesRepository extends JpaRepository<PorcelainPlate , String> {
}
