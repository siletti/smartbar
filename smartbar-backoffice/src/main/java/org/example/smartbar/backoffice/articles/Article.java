package org.example.smartbar.backoffice.articles;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.smartbar.backoffice.BaseEntity;
import org.example.smartbar.backoffice.categories.Category;


import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Article extends BaseEntity {

    private String name;

    private BigDecimal price;

    private String description;

    private String pictureBase64;

    @ManyToOne
    private Category category;
}
