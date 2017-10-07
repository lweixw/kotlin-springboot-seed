package seed.controller

import seed.model.Greeting
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.Description
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import seed.model.Task
import seed.model.TaskCreateResult
import seed.model.ValidationError

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableWebMvc
class TaskControllerEndointIntegrationTest {
	@Autowired
	lateinit var testRestTemplate: TestRestTemplate

	@Test
	fun testTaskControllerWithValidRequest() {
		val task = Task("task", "todo ...")
		val result = testRestTemplate.postForEntity("/api/v1/task", task, TaskCreateResult::class.java)
		assertNotNull(result)
		assertEquals(result.statusCode, HttpStatus.OK)
		assertTrue(result.body.taskId.toInt() > 0)
	}

	@Test
	fun testTaskControllerWithWrongSchema() {
		val task = MalformedTask("task", "todo ...")
		val result = testRestTemplate.postForEntity("/api/v1/task", task, ValidationError::class.java)
		assertNotNull(result)
		assertEquals(result.statusCode, HttpStatus.BAD_REQUEST)
	}

	@Test
	fun testTaskControllerWithBlankValue() {
		val task = Task("", "todo ...")
		val result = testRestTemplate.postForEntity("/api/v1/task", task, ValidationError::class.java)
		assertNotNull(result)
		assertEquals(result.statusCode, HttpStatus.BAD_REQUEST)
	}
}

data class MalformedTask(val name1: String, val description: String)