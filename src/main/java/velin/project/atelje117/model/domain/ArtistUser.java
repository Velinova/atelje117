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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "artists_coworkers",
            joinColumns = {@JoinColumn(name = "artist_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "coworker_id", referencedColumnName = "id")}
    )
    private List<CoworkerUser> coworkers;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY,
            mappedBy = "artist", targetEntity = MonthlyReport.class
    )
    private List<MonthlyReport> reports= new ArrayList<>();
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "artist", targetEntity = PlatesInventory.class
    )
    private List<PlatesInventory> inventories = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "id", targetEntity = GraniteOrder.class)
    private List<GraniteOrder> graniteOrders= new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "id", targetEntity = PorcelainOrder.class)
    private List<PorcelainOrder> porcelainOrders= new ArrayList<>();
    private int userId;

    public ArtistUser(String username, String email, String password, String name, String surname, String city, int userId){
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setName(name);
        this.setSurname(surname);
        this.setCity(city);
        this.setUserId(userId);
        this.setCoworkers(new ArrayList<>());
        this.setGraniteOrders(new ArrayList<>());
        this.setPorcelainOrders(new ArrayList<>());
    }

    @Override
    public String toString() {
        return " ";
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCoworkers(List<CoworkerUser> coworkers) {
        this.coworkers = coworkers;
    }

    public void setReports(List<MonthlyReport> reports) {
        this.reports = reports;
    }

    public void setInventories(List<PlatesInventory> inventories) {
        this.inventories = inventories;
    }

    public void setGraniteOrders(List<GraniteOrder> graniteOrders) {
        this.graniteOrders = graniteOrders;
    }

    public void setPorcelainOrders(List<PorcelainOrder> porcelainOrders) {
        this.porcelainOrders = porcelainOrders;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public List<CoworkerUser> getCoworkers() {
        return coworkers;
    }

    public List<MonthlyReport> getReports() {
        return reports;
    }

    public List<PlatesInventory> getInventories() {
        return inventories;
    }

    public List<GraniteOrder> getGraniteOrders() {
        return graniteOrders;
    }

    public List<PorcelainOrder> getPorcelainOrders() {
        return porcelainOrders;
    }

    public int getUserId() {
        return userId;
    }
}
