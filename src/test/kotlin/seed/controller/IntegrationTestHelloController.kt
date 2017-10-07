package seed.controller

import seed.model.Greeting
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWebMvc
class HelloControllerEndointIntegrationTest {
	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun testHelloControllerDefaultValue() {
		val result = testRestTemplate.getForEntity("/api/v1/hello", Greeting::class.java)
		assertNotNull(result)
		assertEquals(result.statusCode, HttpStatus.OK)
		assertEquals(result.body.message, "Hello World")
	}

	@Test
	fun testHelloControllerWithValidParameter() {
		val result = testRestTemplate.getForEntity("/api/v1/hello?name=Super", Greeting::class.java)
		assertNotNull(result)
		assertEquals(result.statusCode, HttpStatus.OK)
		assertEquals(result.body.message, "Hello Super")
	}
}