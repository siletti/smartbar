package org.example.smartbar.backoffice.articles;

import org.example.smartbar.backoffice.api.model.ApiArticle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.CDI)
public interface ArticleMapper {

    @Mapping(source = "pictureBase64", target = "picture")
    ApiArticle toApiArticle(Article article);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "picture", target = "pictureBase64")
    Article toArticle(ApiArticle apiArticle);
}