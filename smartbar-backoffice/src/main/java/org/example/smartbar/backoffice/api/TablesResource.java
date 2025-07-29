package org.example.smartbar.backoffice.api;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.example.smartbar.backoffice.TablesService;
import org.example.smartbar.backoffice.tables.Table;

import java.net.URI;
import java.util.List;

public class TablesResource implements org.example.smartbar.backoffice.api.TablesApi {

    private final TablesService tablesService;

    @Inject
    public TablesResource(TablesService tablesService) {
        this.tablesService = tablesService;
    }

    @Override
    public Response tablesGet() {
        return Response.ok(List.of(tablesService.get())).build();
    }

    @Override
    public Response tablesPost(org.example.smartbar.backoffice.api.model.ApiTable apiTable) {
        final Table table = new Table();
        table.setName(apiTable.getName());
        table.setSeatCount(apiTable.getSeatCount());
        table.setActive(apiTable.getActive());

        final Table persitedTable = tablesService.persit(table);
        return Response.created(URI.create("/tables/" + persitedTable.getId())).build();
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
    public Response tablesTableIdPut(String tableId, org.example.smartbar.backoffice.api.model.ApiTable table) {
        return Response.ok().build();
    }
}