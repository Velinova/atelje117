package velin.project.atelje117.model.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    public RoleEnum name;
}
