package velin.project.atelje117.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "plates")
@NoArgsConstructor
@AllArgsConstructor
public class PorcelainPlate {
    @Id
    @NotNull
    private String code;
    @Column(name = "isFramed",  nullable = false)
    @NotEmpty
    private boolean framed;
    @Column(name = "dimension",  nullable = false)
    @Enumerated(EnumType.STRING)
    private PlateDimension dimension;
    @Column(name = "shape",  nullable = false)
    @Enumerated(EnumType.STRING)
    private PlateShape shape;
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY, mappedBy = "plate"
    )
    private Set<PlatesInventory> inventories;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isFramed() {
        return framed;
    }

    public void setFramed(boolean framed) {
        this.framed = framed;
    }

    public PlateDimension getDimension() {
        return dimension;
    }

    public void setDimension(PlateDimension dimension) {
        this.dimension = dimension;
    }

    public PlateShape getShape() {
        return shape;
    }

    public void setShape(PlateShape shape) {
        this.shape = shape;
    }

    public Set<PlatesInventory> getInventories() {
        return inventories;
    }

    public void setInventories(Set<PlatesInventory> inventories) {
        this.inventories = inventories;
    }
}
