package seed.controller

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import seed.service.HelloService
import seed.model.Greeting
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UnitTestHelloController {

	private var helloController: HelloController? = null
	private var helloService: HelloService? = null

	@Before
	fun setup() {
		helloService = mock(HelloService::class.java)
		helloController = HelloController(helloService!!)
	}

	@Test
	fun testHelloController() {
		given(helloService?.getHelloGreeting("Jackson", 1)).willReturn(Greeting("Hi Jackson", 1))
		val result = helloController?.sayHelloTo("Jackson")
		assertNotNull(result)
		assertEquals(result?.message, "Hi Jackson")
	}
}