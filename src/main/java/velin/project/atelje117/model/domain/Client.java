package velin.project.atelje117.model.domain;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.CodePointLength;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;


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
    @NotNull(message = "Please provide client's birth date")
    @Column(name = "birthDate", nullable = false)
    private Date birthDate;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Please provide client's death date")
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public GraniteOrder getGraniteOrder() {
        return graniteOrder;
    }

    public void setGraniteOrder(GraniteOrder graniteOrder) {
        this.graniteOrder = graniteOrder;
    }

    public PorcelainOrder getPorcelainOrder() {
        return porcelainOrder;
    }

    public void setPorcelainOrder(PorcelainOrder porcelainOrder) {
        this.porcelainOrder = porcelainOrder;
    }

    public int getGranitePortraitPhotograph() {
        return granitePortraitPhotograph;
    }

    public void setGranitePortraitPhotograph(int granitePortraitPhotograph) {
        this.granitePortraitPhotograph = granitePortraitPhotograph;
    }

    public int getGraniteFigurePhotograph() {
        return graniteFigurePhotograph;
    }

    public void setGraniteFigurePhotograph(int graniteFigurePhotograph) {
        this.graniteFigurePhotograph = graniteFigurePhotograph;
    }

    public int getPorcelainPhotograph() {
        return porcelainPhotograph;
    }

    public void setPorcelainPhotograph(int porcelainPhotograph) {
        this.porcelainPhotograph = porcelainPhotograph;
    }
}
