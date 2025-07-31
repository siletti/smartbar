package org.example.smartbar.backoffice.tables;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.example.smartbar.backoffice.api.TablesApi;
import org.example.smartbar.backoffice.api.model.ApiTable;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class TablesResource implements TablesApi {

    private final TablesService tablesService;

    private final TableMapper mapper;

    @Inject
    public TablesResource(TablesService tablesService, TableMapper mapper) {
        this.tablesService = tablesService;
        this.mapper = mapper;
    }

    @Override
    public Response tablesGet() {
        final List<Table> tables = tablesService.listAll();
        return Response.ok(tables.stream().map(mapper::toApiTable).toList())
                .build();
    }

    @Override
    public Response tablesPost(ApiTable apiTable) {
        final Table persitedTable = tablesService.persit(mapper.toTable(apiTable));
        return Response.created(URI.create("/tables/" + persitedTable.getId())).build();
    }

    @Override
    public Response tablesTableIdDelete(Long tableId) {
        final Optional<Table> table = tablesService.deleteById(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }

    @Override
    public Response tablesTableIdGet(Long tableId) {
        final Optional<Table> table = tablesService.getById(tableId);
        if (table.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(mapper.toApiTable(table.get())).build();
    }

    @Override
    public Response tablesTableIdPut(Long tableId, ApiTable apiTable) {
        final Optional<Table> existingTable = tablesService.getById(tableId);
        if (existingTable.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Table table = mapper.toTable(apiTable);
        table.setId(tableId);
        tablesService.update(table);
        return Response.ok().build();
    }
}