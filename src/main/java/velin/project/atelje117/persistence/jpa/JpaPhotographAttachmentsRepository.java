package velin.project.atelje117.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import velin.project.atelje117.model.domain.PhotographAttachment;

import java.util.UUID;

public interface JpaPhotographAttachmentsRepository extends JpaRepository<PhotographAttachment, Integer> {
}
