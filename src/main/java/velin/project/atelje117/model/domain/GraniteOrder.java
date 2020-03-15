package velin.project.atelje117.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "graniteOrders")
public class GraniteOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "dueTo",  nullable = false)
    @NotEmpty(message = "Please provide due to date")
    private Date dueTo;
    @Column(name = "noteArtist",  nullable = true)
    private String noteArtist;
    @Column(name = "noteCoworker",  nullable = true)
    private String noteCoworker;
    @Column(name="epilogue",  nullable = false)
    private String epilogue;
    @Column(name = "graniteType",  nullable = false)
    @Enumerated(EnumType.STRING)
    private GraniteType graniteType;
    @Enumerated(EnumType.STRING)
    @Column(name = "orderType",  nullable = false)
    private GraniteOrderType orderType;
    @Enumerated(EnumType.STRING)
    @Column(name = "status",  nullable = false)
    private OrderStatus status;
    @Column(name = "price",  nullable = false)
    private int price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="coworkerId", nullable = false)
    private CoworkerUser coworker;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clientId", referencedColumnName = "id", nullable = false)
    private Client client;
}
