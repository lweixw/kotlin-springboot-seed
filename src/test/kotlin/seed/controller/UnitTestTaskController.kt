package seed.controller

import org.junit.Assert.*
import seed.model.Greeting
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.runners.MockitoJUnitRunner
import seed.model.Task

@RunWith(MockitoJUnitRunner::class)
class UnitTestTaskController {

	private val taskController = TaskController()

	@Before
	fun setup() {
	}

	@Test
	fun testTaskController() {
		val task = Task("task", "desc")
		val result = taskController.createTask(task)
		assertNotNull(result)
		assertTrue(result.taskId.toInt() > 0)
	}
}