package velin.project.atelje117.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
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
public class ArtistUser {
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

    private int userId;

    public ArtistUser(String username, String email, String password, String name, String surname, String city, int userId){
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setName(name);
        this.setSurname(surname);
        this.setCity(city);
        this.setUserId(userId);
    }
}
