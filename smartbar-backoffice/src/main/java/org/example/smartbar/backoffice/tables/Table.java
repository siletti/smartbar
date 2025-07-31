package org.example.smartbar.backoffice.tables;

import jakarta.persistence.Entity;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.smartbar.backoffice.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@jakarta.persistence.Table(name = "Sbo_Table", uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})@Data
public class Table extends BaseEntity{
    @NotNull
    private String name;
    @NotNull
    private Integer seatCount;
    @NotNull
    private Boolean active;
}
