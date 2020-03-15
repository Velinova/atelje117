package velin.project.atelje117.model.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "artists", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class ArtistUser extends User {
    @Column(name = "companyName",  nullable = false)
    @NotBlank(message = "Please provide company name")
    private String companyName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "artists_coworkers",
            joinColumns = {@JoinColumn(name = "artist_id")},
            inverseJoinColumns = {@JoinColumn(name = "coworker_id")}
    )
    private Set<CoworkerUser> coworkers;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            mappedBy = "artist", targetEntity = MonthlyReport.class
    )
    private Set<MonthlyReport> reports;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "artist", targetEntity = PlatesInventory.class
    )
    private Set<PlatesInventory> inventories;

}
