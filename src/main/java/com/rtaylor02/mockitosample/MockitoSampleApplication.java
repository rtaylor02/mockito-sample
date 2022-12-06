package com.rtaylor02.mockitosample;

import com.rtaylor02.mockitosample.business.ItemBusinessService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MockitoSampleApplication {

	public static void main(String[] args) {
		ApplicationContext ctx =  SpringApplication.run(MockitoSampleApplication.class, args);
		ItemBusinessService businessService = ctx.getBean((ItemBusinessService.class));
		System.out.println(businessService);
	}

}
