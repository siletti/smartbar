package org.example.smartbar.backoffice.categories;

import org.example.smartbar.backoffice.api.model.ApiCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface CategoryMapper {

    ApiCategory toApiCategory(Category category);

    @Mapping(target = "id", ignore = true)
    Category toCategory(ApiCategory apiCategory);
}