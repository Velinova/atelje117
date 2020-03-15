package velin.project.atelje117.model.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "coworkers", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class CoworkerUser extends User {
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Please provide coworker type")
    @Column(name = "type",  nullable = false)
    private CoworkerType type;
    @ManyToMany(mappedBy = "coworkers", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<ArtistUser> artists;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "id", targetEntity = GraniteOrder.class)
    private Set<GraniteOrder> graniteOrders;
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "id", targetEntity = PorcelainOrder.class)
    private Set<GraniteOrder> porcelainOrders;

}
