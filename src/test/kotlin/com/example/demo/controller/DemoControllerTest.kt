package com.example.demo.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus.OK

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class DemoControllerTest(@Autowired val restTemplate: TestRestTemplate) {

    @Test
    fun `geeft hello`() {
        val response = restTemplate.getForEntity<String>("/")
        assertThat(response.statusCode).isEqualTo(OK)
        assertThat(response.body).isEqualTo("Hello!")
    }
}


