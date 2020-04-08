package velin.project.atelje117.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Data
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
    @NotEmpty(message = "Please provide due to date")
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
}
