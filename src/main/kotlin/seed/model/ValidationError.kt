package seed.model

data class ValidationError(
	val errors: List<String>,
	val errorMessage: String
)
