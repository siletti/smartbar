package org.example.smartbar.backoffice;

import jakarta.enterprise.context.ApplicationScoped;
import org.example.smartbar.backoffice.api.model.Table;

@ApplicationScoped
public class TablesService {

    public Table get() {
        return new Table().name("Berlin");
    }

}