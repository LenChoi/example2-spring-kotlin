package com.example.blog

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests(@Autowired val entityManager: TestEntityManager,
                        @Autowired val userRepository: UserRepository,
                        @Autowired val articleRepository: ArticleRepositories) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        // given
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen) // 엔티티 저장
        val article = Article("Spring Framework 5.0 goes GA", "Deer Spring community...", "Lorem ipsum", juergen)
        entityManager.persist(article)
        entityManager.flush() // 영속성 컨텍스트 내용을 데이터베이스에 반영

        val test = Article("test", "test", "test", juergen)

        // when
        val found = articleRepository.findByIdOrNull(article.id!!) // !!는 널값이 절때 들어오면 안되는 경우  붙여준다고 하는데... id는 ?로 설정해서 null이 가능하고 그래서 여기에 null이 들어가는 것을 방지하는 것 같다. 그런데
//        val foundTest = articleRepository.findById(test.id!!) // 테스트 결과: null이 들어가면 오류가 뜬다, !!를 붙이지 않으니깐 오류를 표시한다
          println("found = ${found}")
//        println("foundTest = ${foundTest}")

        // then
        assertThat(found).isEqualTo(article)
    }
    
    @Test
    fun `When findByLogin then return User`() {
        // given
        val juergen = User("springjuergen", "Juergen", "Hoeller")
        entityManager.persist(juergen)
        entityManager.flush()

        // when
        val found = userRepository.findByLogin(juergen.login)

        // then
        assertThat(found).isEqualTo(juergen)
    }
}