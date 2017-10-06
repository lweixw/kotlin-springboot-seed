package seed.controller

import seed.service.HelloService
import seed.model.Greeting
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/api/v1")
class HelloController {
    private val logger = LoggerFactory.getLogger(HelloController::class.java)
    private var helloService: HelloService
    private var counter: AtomicLong = AtomicLong(0)

    @Autowired
    constructor(helloService: HelloService) {
        this.helloService = helloService
    }

    @GetMapping("/hello")
    fun sayHelloTo(@RequestParam(value = "name", defaultValue = "World") name: String): Greeting {
        logger.info("request is coming in, name=[$name]")
        return helloService.getHelloGreeting(name, counter.incrementAndGet())
    }
}
