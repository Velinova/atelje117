package velin.project.atelje117.persistence.implementation;

import org.springframework.stereotype.Repository;
import velin.project.atelje117.model.domain.PhotographAttachment;
import velin.project.atelje117.persistence.jpa.JpaPhotographAttachmentsRepository;
import velin.project.atelje117.persistence.repositories.IPhotographAttachmentsRepository;

import java.util.List;
import java.util.UUID;

@Repository
public class PhotographAtachmentsRepository implements IPhotographAttachmentsRepository {
    private final JpaPhotographAttachmentsRepository repository;

    public PhotographAtachmentsRepository(JpaPhotographAttachmentsRepository repository){
        this.repository = repository;
    }

    @Override
    public PhotographAttachment getOne(int Id) {
        return  this.repository.getOne(Id);
    }

    @Override
    public List<PhotographAttachment> findAll() {
        return this.repository.findAll();
    }

    @Override
    public PhotographAttachment save(PhotographAttachment attachment) {
        return this.repository.save(attachment);
    }

    @Override
    public void deleteById(int Id) {
        this.repository.deleteById(Id);
    }

    @Override
    public void delete(PhotographAttachment attachment) {
        this.repository.delete(attachment);
    }
}
