package com.example.blog

import com.example.blog.util.toSlug
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.getForObject
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // 기본 값은 WebEnvironment.MOCK인데 이건 실제 서블릿 컨테이너를 띄우지 않기 때문에 random port 사용
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) { // MoockingTesting과의 차이는 실제 서블릿 컨테이너 실행 여부이며 RestTestTemplate는 컨테이너를 직접 실행함

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `Assert blog page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/") // 주어진 URL 주소로 HTTP GET 메서드로 결과는 ResponseEntity로 반환받는다
        //val entity2 = restTemplate.getForObject<String>("/") 주어진 URL 주소로 HTTP GET 메서드로 객체로 결과를 반환받는다
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<h1>Blog</h1>", "Reactor")
    }

    @Test
    fun `Assert article page title, content and status code`() {
        println(">> Assert article page title, content and status code")
        val title = "Reactor Aluminium has landed"
        val entity = restTemplate.getForEntity<String>("/article/${title.toSlug()}")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains(title, "Lorem ipsum", "dolor sit amet")
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }

}