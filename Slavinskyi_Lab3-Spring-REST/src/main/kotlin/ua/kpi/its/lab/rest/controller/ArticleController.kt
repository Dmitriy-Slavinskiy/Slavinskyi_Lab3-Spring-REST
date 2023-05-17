package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.ArticleRequest
import ua.kpi.its.lab.rest.dto.ArticleResponse
import ua.kpi.its.lab.rest.svc.impl.ArticleServiceImpl

@RestController
@RequestMapping("/article")
class ArticleController(private val articleService: ArticleServiceImpl) {
    @PostMapping
    fun createArticle(@RequestBody articleRequest: ArticleRequest): ResponseEntity<ArticleResponse> {
        val articleResponse = articleService.createArticle(articleRequest)
        return ResponseEntity(articleResponse, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getArticleById(@PathVariable id: Long): ResponseEntity<ArticleResponse> {
        val articleResponse = articleService.getArticleById(id)
        return ResponseEntity(articleResponse, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateArticle(@PathVariable id: Long, @RequestBody articleRequest: ArticleRequest): ResponseEntity<ArticleResponse> {
        val articleResponse = articleService.updateArticle(id, articleRequest)
        return ResponseEntity(articleResponse, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteArticle(@PathVariable id: Long): ResponseEntity<Void> {
        articleService.deleteArticle(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}