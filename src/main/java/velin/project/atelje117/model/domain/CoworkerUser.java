package velin.project.atelje117.model.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    private List<ArtistUser> artists= new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "id", targetEntity = GraniteOrder.class)
    private List<GraniteOrder> graniteOrders= new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "id", targetEntity = PorcelainOrder.class)
    private List<PorcelainOrder> porcelainOrders= new ArrayList<>();

    private int userId;

    public CoworkerUser(String username, String email, String password, String name, String surname, String city, int userId){
        this.setUsername(username);
        this.setUserId(userId);
        this.setEmail(email);
        this.setPassword(password);
        this.setName(name);
        this.setSurname(surname);
        this.setCity(city);
        this.setArtists(new ArrayList<>());
        this.setGraniteOrders(new ArrayList<>());
        this.setPorcelainOrders(new ArrayList<>());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ArtistUser> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistUser> artists) {
        this.artists = artists;
    }

    public List<GraniteOrder> getGraniteOrders() {
        return graniteOrders;
    }

    public void setGraniteOrders(List<GraniteOrder> graniteOrders) {
        this.graniteOrders = graniteOrders;
    }

    public List<PorcelainOrder> getPorcelainOrders() {
        return porcelainOrders;
    }

    public void setPorcelainOrders(List<PorcelainOrder> porcelainOrders) {
        this.porcelainOrders = porcelainOrders;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
