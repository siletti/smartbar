package org.example.smartbar.backoffice.articles;

import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.example.smartbar.backoffice.api.ArticlesApi;
import org.example.smartbar.backoffice.api.model.ApiArticle;
import org.example.smartbar.backoffice.categories.CategoriesService;
import org.example.smartbar.backoffice.categories.Category;

import java.net.URI;
import java.util.List;
import java.util.Optional;



public class ArticlesResource implements ArticlesApi {

    private final ArticlesService articlesService;

    private final CategoriesService categoriesService;

    private final ArticleMapper articleMapper;

    @Inject
    public ArticlesResource(ArticlesService articlesService, CategoriesService categoriesService, ArticleMapper articleMapper) {
        this.articlesService = articlesService;
        this.categoriesService = categoriesService;
        this.articleMapper = articleMapper;
    }

    @Override
    public Response articlesArticleIdDelete(Long articleId) {
        final Optional<Article> article = articlesService.deleteById(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().build();
    }

    @Override
    public Response articlesArticleIdGet(Long articleId) {
        final Optional<Article> article = articlesService.getById(articleId);
        if (article.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(articleMapper.toApiArticle(article.get())).build();
    }

    @Override
    public Response articlesArticleIdPut(Long articleId, ApiArticle apiArticle) {
        final Optional<Article> existingArticle = articlesService.getById(articleId);
        if (existingArticle.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = articleMapper.toArticle(apiArticle);
        article.setId(articleId);
        articlesService.update(article);
        return Response.ok().build();
    }

    @Override
    public Response articlesGet() {
        final List<Article> articles = articlesService.listAll();
        return Response.ok(articles.stream().map(articleMapper::toApiArticle).toList())
                .build();
    }

    @Override
    public Response articlesPost(Long xCategoryId, ApiArticle apiArticle) {
        final Optional<Category> category = categoriesService.getById(xCategoryId);
        if(category.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        final Article article = articleMapper.toArticle(apiArticle);
        article.setCategory(category.get());
        final Article persitedArticle = articlesService.persit(article);
        return Response.created(URI.create("/articles/" + persitedArticle.getId())).build();
    }


}