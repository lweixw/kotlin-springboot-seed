package seed.conf

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor
import seed.App
import javax.validation.Validator

@Configuration
@ComponentScan(basePackageClasses = arrayOf(App::class))
class SpringTestConfig {
}