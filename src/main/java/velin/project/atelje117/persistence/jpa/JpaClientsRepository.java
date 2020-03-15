package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.Client;
import velin.project.atelje117.persistence.repositories.IClientsRepository;

import java.util.UUID;

public interface JpaClientsRepository extends JpaRepository<Client, Integer> {
}
