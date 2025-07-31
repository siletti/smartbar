package org.example.smartbar.backoffice.articles;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.example.smartbar.backoffice.CrudService;

@ApplicationScoped
public class ArticlesService extends CrudService<Article> {

    public ArticlesService() {
        // For CDI needs
        super(null);
    }

    @Inject
    public ArticlesService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Article> getEntityClass() {
        return Article.class;
    }

}