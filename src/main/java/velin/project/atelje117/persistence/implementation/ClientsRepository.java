package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.Client;
import velin.project.atelje117.persistence.jpa.JpaClientsRepository;
import velin.project.atelje117.persistence.repositories.IClientsRepository;

import java.util.List;

@Repository
public class ClientsRepository implements IClientsRepository {
    private final JpaClientsRepository repository;

    public ClientsRepository(JpaClientsRepository repository) {

        this.repository = repository;

    }

    @Override
    public Client getOne(int Id) {
        return this.repository.getOne(Id);
    }

    @Override
    public List<Client> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Client save(Client client) {
        return this.repository.save(client);
    }


    @Override
    public void deleteById(int Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public void delete(Client client) {
        this.repository.delete(client);
    }
}
