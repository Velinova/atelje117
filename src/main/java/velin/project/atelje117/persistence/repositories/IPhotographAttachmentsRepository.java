package velin.project.atelje117.persistence.repositories;


import velin.project.atelje117.model.domain.PhotographAttachment;

import java.util.List;
import java.util.UUID;

public interface IPhotographAttachmentsRepository {
    PhotographAttachment getOne(int Id);
    List<PhotographAttachment> findAll();
    PhotographAttachment save(PhotographAttachment attachment);
    void deleteById(int Id);
    void delete(PhotographAttachment attachment);
}
