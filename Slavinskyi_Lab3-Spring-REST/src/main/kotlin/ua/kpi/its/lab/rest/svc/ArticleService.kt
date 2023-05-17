package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.ArticleRequest
import ua.kpi.its.lab.rest.dto.ArticleResponse
interface ArticleService {
    fun createArticle(drugsRequest: ArticleRequest): ArticleResponse
    fun getArticleById(id: Long): ArticleResponse
    fun updateArticle(id: Long, drugsRequest: ArticleRequest): ArticleResponse
    fun deleteArticle(id: Long)
}