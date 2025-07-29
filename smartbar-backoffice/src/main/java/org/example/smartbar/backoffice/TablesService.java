package org.example.smartbar.backoffice;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.example.smartbar.backoffice.tables.Table;



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

    public org.example.smartbar.backoffice.api.model.ApiTable get() {
        return new org.example.smartbar.backoffice.api.model.ApiTable().name("Berlin");
    }

}