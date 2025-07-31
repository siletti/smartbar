package org.example.smartbar.backoffice.tables;

import org.example.smartbar.backoffice.api.model.ApiTable;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface TableMapper {

    ApiTable toApiTable(Table table);

    @Mapping(target = "id", ignore = true)
    Table toTable(ApiTable apiTable);
}