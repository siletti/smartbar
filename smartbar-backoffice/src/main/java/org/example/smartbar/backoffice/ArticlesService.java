package org.example.smartbar.backoffice;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.smartbar.backoffice.api.model.Article;

@ApplicationScoped
public class ArticlesService {

    public Article get() {
        return new Article().name("cola");
    }

}