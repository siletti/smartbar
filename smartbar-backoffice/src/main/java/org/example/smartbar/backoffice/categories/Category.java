package org.example.smartbar.backoffice.categories;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.smartbar.backoffice.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
public class Category extends BaseEntity {

    private String name;

    private String description;
}
