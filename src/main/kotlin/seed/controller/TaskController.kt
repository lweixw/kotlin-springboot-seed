package seed.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*
import seed.model.Task
import seed.model.TaskCreateResult
import seed.model.ValidationError
import seed.util.ValidationErrorBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1")
class TaskController {
	private val logger = LoggerFactory.getLogger(TaskController::class.java)

	@PostMapping("/task")
	fun createTask(@Valid @RequestBody task: Task): TaskCreateResult {
		return TaskCreateResult(100)
	}
}
