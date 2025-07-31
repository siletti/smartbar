package org.example.smartbar.backoffice.articles;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.smartbar.backoffice.BaseEntity;
import org.example.smartbar.backoffice.categories.Category;


import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name", "category_id"})
})
public class Article extends BaseEntity {

    @NotNull
    private String name;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    private String description;

    @NotNull
    private String pictureBase64;

    @ManyToOne(optional = false)
    @JoinColumn(name = "category_id")
    private Category category;
}
