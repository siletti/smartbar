package org.example.smartbar.backoffice.categories;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.example.smartbar.backoffice.api.CategoriesApi;
import org.example.smartbar.backoffice.api.model.ApiCategory;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class CategoriesResource implements CategoriesApi {

    private final CategoriesService categoriesService;
    private final CategoryMapper categoryMapper;

    @Inject
    public CategoriesResource(CategoriesService categoriesService, CategoryMapper categoryMapper) {
        this.categoriesService = categoriesService;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Response categoriesCategoryIdDelete(Long categoryId) {
        final Optional<Category> category = categoriesService.deleteById(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }

    @Override
    public Response categoriesCategoryIdGet(Long categoryId) {
        final Optional<Category> category = categoriesService.getById(categoryId);
        if (category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(categoryMapper.toApiCategory(category.get())).build();
    }

    @Override
    public Response categoriesCategoryIdPut(Long categoryId, ApiCategory apiCategory) {
        final Optional<Category> existingCategory = categoriesService.getById(categoryId);
        if (existingCategory.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Category category = existingCategory.get();
        // Utilizza il mapper per aggiornare la categoria esistente
        Category updatedCategory = categoryMapper.toCategory(apiCategory);
        updatedCategory.setId(category.getId()); // Mantieni l'ID esistente
        categoriesService.update(updatedCategory);
        return Response.ok().build();
    }

    @Override
    public Response categoriesGet() {
        final List<Category> categories = categoriesService.listAll();
        return Response.ok(categories.stream().map(categoryMapper::toApiCategory).toList())
                .build();
    }

    @Override
    public Response categoriesPost(ApiCategory apiCategory) {
        final Category category = categoryMapper.toCategory(apiCategory);
        final Category persitedCategory = categoriesService.persit(category);
        return Response.created(URI.create("/categories/" + persitedCategory.getId())).build();
    }
}