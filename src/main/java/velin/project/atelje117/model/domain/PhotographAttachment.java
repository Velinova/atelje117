package velin.project.atelje117.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "attachments")
public class PhotographAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "attachmentName",  nullable = false)
    private  String fileName;
    @Column(name = "contentLength",  nullable = false)
    private int contentLength;
    @Lob
    @Column(name="[content]",  nullable = false)
    private byte[] content;
    @Column(name = "contentType",  nullable = false)
    private String contentType;




}
