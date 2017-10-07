package seed.handler.validation

import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import seed.model.ValidationError
import seed.util.ValidationErrorBuilder

@ControllerAdvice
class ValidationHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException::class)
	fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ValidationError {
		return ValidationErrorBuilder.fromValidationErrors(exception.bindingResult)
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(HttpMessageNotReadableException::class)
	fun handleHttpMessageNotReadableException(exception: HttpMessageNotReadableException): ValidationError {
		return ValidationErrorBuilder.fromNotReadableException(exception)
	}
}