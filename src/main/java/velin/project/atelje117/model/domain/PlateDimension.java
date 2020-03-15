package velin.project.atelje117.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum PlateDimension {
    TYPE_1("9x11"),
    TYPE_2("10x12"),
    TYPE_3("11x15"),
    TYPE_4("12x14"),
    TYPE_5("13x18"),
    TYPE_6("18x24");

    private String description;
}


