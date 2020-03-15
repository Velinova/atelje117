package velin.project.atelje117.model.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.UUID;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "name",  nullable = false)
    @NotBlank(message = "Please provide client's name")
    private String name;
    @Column(name = "surname",  nullable = false)
    @NotBlank(message = "Please provide client's surname")
    private String surname;
    @Temporal(TemporalType.DATE)
    @NotEmpty(message = "Please provide client's birth date")
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    @NotEmpty(message = "Please provide client's death date")
    @Column(name = "deathDate", nullable = false)
    private Date deathDate;
    @OneToOne()
    @JoinColumn(name="graniteOrderId", nullable = false)
    private GraniteOrder graniteOrder;
    @OneToOne()
    @JoinColumn(name="porcelainOrderId", nullable = false)
    private PorcelainOrder porcelainOrder;
    @Column(name = "portraitPhotographId", nullable = false)
    private int granitePortraitPhotograph;
    @Column(name = "figurePhotographId", nullable = false)
    private int graniteFigurePhotograph;
    @Column(name = "porcelainPhotographId", nullable = false)
    private int porcelainPhotograph;
}
