package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.ArticleRequest
import ua.kpi.its.lab.rest.dto.ArticleResponse
import ua.kpi.its.lab.rest.entity.Article
import ua.kpi.its.lab.rest.repository.ArticleRepository
import ua.kpi.its.lab.rest.svc.ArticleService
@Service
class ArticleServiceImpl(private val articleRepository: ArticleRepository) : ArticleService {
    override fun createArticle(articleRequest: ArticleRequest): ArticleResponse {
        val article = Article(author = articleRequest.name, dateofwriting = articleRequest.description)
        val savedArticle = articleRepository.save(article)
        return ArticleResponse.fromEntity(savedArticle)
    }

    override fun getArticleById(id: Long): ArticleResponse {
        val article = articleRepository.findById(id).orElseThrow()
        return ArticleResponse.fromEntity(article)
    }

    override fun updateArticle(id: Long, articleRequest: ArticleRequest): ArticleResponse {
        val article = articleRepository.findById(id).orElseThrow()
        article.author = articleRequest.name
        article.dateofwriting = articleRequest.description
        val updatedArticle = articleRepository.save(article)
        return ArticleResponse.fromEntity(updatedArticle)
    }

    override fun deleteArticle(id: Long) {
        articleRepository.deleteById(id)
    }
}