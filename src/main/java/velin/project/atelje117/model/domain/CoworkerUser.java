package velin.project.atelje117.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
public class CoworkerUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "username", nullable = false)
    @NotBlank(message = "Please provide email username")
    private String username;

    @Column(name = "email",  nullable = false)
    @Email(message = "Please provide valid email address")
    @NotBlank(message = "Please provide email address")
    private String email;

    @Column(name = "password",  nullable = false)
    @Length(min = 6, message = "*Your password must have at least 6 characters")
    @NotBlank(message = "Please provide password")
    private String password;

    @Column(name = "name",  nullable = false)
    @NotBlank(message = "Please provide name")
    private String name;

    @Column(name = "surname",  nullable = false)
    @NotBlank(message = "Please provide surname")
    private String surname;

    @Column(name = "city",  nullable = false)
    @NotBlank(message = "Please provide city")
    private String city;

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

    private int userId;

    public CoworkerUser(String username, String email, String password, String name, String surname, String city, int userId){
        this.setUsername(username);
        this.setUserId(userId);
        this.setEmail(email);
        this.setPassword(password);
        this.setName(name);
        this.setSurname(surname);
        this.setCity(city);
    }
}
