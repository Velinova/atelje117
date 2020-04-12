package velin.project.atelje117.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "porcelainOrders")
public class PorcelainOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private int id;
    @Temporal(TemporalType.DATE)
    @Column(name = "dueTo",  nullable = false)
    @NotNull(message = "Please provide due to date")
    private Date dueTo;
    @Column(name = "noteArtist",  nullable = true)
    private String noteArtist;
    @Column(name = "noteCoworker",  nullable = true)
    private String noteCoworker;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Column(name = "price",  nullable = false)
    private int price;
    @Column(name="colorType",  nullable = false)
    @Enumerated(EnumType.STRING)
    private ColorType colorType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coworkerId", nullable = false)
    private CoworkerUser coworker;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistId", nullable = false)
    private ArtistUser artist;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "id", nullable = false)
    private Client client;
    @Column(name="plateCode",  nullable = false)
    private String plateCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDueTo() {
        return dueTo;
    }

    public void setDueTo(Date dueTo) {
        this.dueTo = dueTo;
    }

    public String getNoteArtist() {
        return noteArtist;
    }

    public void setNoteArtist(String noteArtist) {
        this.noteArtist = noteArtist;
    }

    public String getNoteCoworker() {
        return noteCoworker;
    }

    public void setNoteCoworker(String noteCoworker) {
        this.noteCoworker = noteCoworker;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
    }

    public CoworkerUser getCoworker() {
        return coworker;
    }

    public void setCoworker(CoworkerUser coworker) {
        this.coworker = coworker;
    }

    public ArtistUser getArtist() {
        return artist;
    }

    public void setArtist(ArtistUser artist) {
        this.artist = artist;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getPlateCode() {
        return plateCode;
    }

    public void setPlateCode(String plateCode) {
        this.plateCode = plateCode;
    }
}
