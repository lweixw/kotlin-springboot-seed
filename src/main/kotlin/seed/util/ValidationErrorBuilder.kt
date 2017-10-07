package seed.util

import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.Errors
import seed.model.ValidationError

class ValidationErrorBuilder {
	companion object {
		fun fromValidationErrors(errors: Errors): ValidationError {
			return ValidationError(errors.allErrors.map { it.defaultMessage },"Validation failed. " + errors.allErrors.size + " error(s)")
		}

		fun fromNotReadableException(ex: HttpMessageNotReadableException): ValidationError {
			return ValidationError(listOf(ex.localizedMessage), "Validation failed. 1 error(s)\"")
		}
	}
}