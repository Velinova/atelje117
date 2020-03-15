package velin.project.atelje117.model.domain;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users",  uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements Serializable {
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
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public void setRoles(Set<Role> roles){
        this.roles = roles;
    }
    public User(String Name, String Surname, String Username, String Email, String Password, String City){
        this.setName(Name);
        this.setSurname(Surname);
        this.setUsername(Username);
        this.setPassword(Password);
        this.setEmail(Email);
        this.setCity(City);
    }
}
