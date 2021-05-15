package com.example.blog

import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long> {
    fun findBySlug(slug: String): Article?
    fun findAllByOrderByAddedAtDesc(): Iterable<Article> // AddedAt을 가져오는데 내림차순으로 가져온다? 정렬은 처음봄 나중에 확인
}

interface UserRepository: CrudRepository<User, Long> {
    fun findByLogin(login: String): User?
}