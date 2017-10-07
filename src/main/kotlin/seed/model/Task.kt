package seed.model

import org.hibernate.validator.constraints.NotBlank

data class Task(
	@field:NotBlank(message = "Task name must not be blank")
	val name: String,

	@field:NotBlank(message = "Task description must not be blank")
	val description: String
)