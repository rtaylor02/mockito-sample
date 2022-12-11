package com.rtaylor02.mockitosample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
/*
@TestPropertySource: this has the highest priority, i.e. the test application will only use this.
 */
//@TestPropertySource(locations = {"classpath:test-configuration.properties"})
class MockitoSampleApplicationTests {

	@Test
	void contextLoads() {
	}

}
