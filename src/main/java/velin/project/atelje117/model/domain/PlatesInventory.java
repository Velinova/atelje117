package velin.project.atelje117.model.domain;

import lombok.*;

import javax.persistence.*;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public PorcelainPlate getPlate() {
        return plate;
    }

    public void setPlate(PorcelainPlate plate) {
        this.plate = plate;
    }

    public ArtistUser getArtist() {
        return artist;
    }

    public void setArtist(ArtistUser artist) {
        this.artist = artist;
    }
}
