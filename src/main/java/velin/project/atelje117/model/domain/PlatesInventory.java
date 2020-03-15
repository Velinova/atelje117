package velin.project.atelje117.model.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "inventories")
public class PlatesInventory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  nullable = false)
    private int id;
    @Column(name = "count",  nullable = false)
    private int count;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plateCode", nullable = false)
    private PorcelainPlate plate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artistId", nullable = false)
    private ArtistUser artist;

}
