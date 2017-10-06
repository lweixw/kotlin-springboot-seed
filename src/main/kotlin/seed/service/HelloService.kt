package seed.service

import seed.model.Greeting
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class HelloService {
	private val logger = LoggerFactory.getLogger(HelloService::class.java)

	public fun getHelloGreeting(name: String, counter: Long): Greeting {
		logger.info("getHelloGreeting, name=$name, counter=$counter")
		return Greeting("Hello $name", counter)
	}
}