package org.example.smartbar.backoffice;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.smartbar.backoffice.api.model.Category;

@ApplicationScoped
public class CategoriesService {

    public Category get() {
        return new Category().name("drinks");
    }

}