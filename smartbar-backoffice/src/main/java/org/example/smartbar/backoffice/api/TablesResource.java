package org.example.smartbar.backoffice.api;

import io.smallrye.common.annotation.NonBlocking;
import jakarta.inject.Inject;
import org.example.smartbar.backoffice.TablesService;
import org.example.smartbar.backoffice.api.model.Table;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.util.List;

@NonBlocking
public class TablesResource implements TablesApi {

    private final TablesService tablesService;

    @Inject
    public TablesResource(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @Override
    public Response tablesTableIdDelete(String tableId) {
        return Response.ok().build();
    }

    @Override
    public Response tablesTableIdGet(String tableId) {
        return Response.ok(tablesService.get()).build();
    }

    @Override
    public Response tablesTableIdPut(String tableId, Table table) {
        return Response.ok().build();
    }

    @Override
    public Response tablesGet() {
        return Response.ok(List.of(tablesService.get())).build();
    }

    @Override
    public Response tablesPost(Table table) {
        return Response.created(URI.create("todo")).build();
    }
}
