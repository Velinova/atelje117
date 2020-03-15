package velin.project.atelje117.persistence.repositories;

import velin.project.atelje117.model.domain.Client;

import java.util.List;
import java.util.UUID;

public interface IClientsRepository {
    Client getOne (int Id);
    List<Client> findAll ();
    Client save (Client client);
    void deleteById (int Id);
    void delete (Client client);
}
