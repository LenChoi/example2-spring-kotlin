package com.example.blog.configure

import com.example.blog.Article
import com.example.blog.ArticleRepository
import com.example.blog.User
import com.example.blog.UserRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) =
        ApplicationRunner { // 애플리케이션이 구동된 후에 코드가 실행
            val smaldini = userRepository.save(User("smaldini", "Stephane", "Maldini"))
            articleRepository.save(Article(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            ))
            articleRepository.save(Article(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            ))
        }
}