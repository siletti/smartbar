package org.example.smartbar.backoffice.tables;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.example.smartbar.backoffice.CrudService;

@ApplicationScoped
public class TablesService extends CrudService<Table> {


    public TablesService() {
        // Just for CDI requirements
        super(null);
    }

    @Inject
    public TablesService(EntityManager entityManager) {
        super(entityManager);
    }


    @Override
    protected Class<Table> getEntityClass() {
        return Table.class;
    }
}