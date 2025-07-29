package org.example.smartbar.backoffice.tables;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.smartbar.backoffice.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@jakarta.persistence.Table(name = "Sbo_Table")
@Data
public class Table extends BaseEntity{
    private String name;
    private Integer seatCount;
    private Boolean active;
}
