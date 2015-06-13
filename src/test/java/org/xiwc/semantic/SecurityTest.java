package org.xiwc.semantic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringApplicationConfiguration(classes = Application.class)
public class SecurityTest extends AbstractTestNGSpringContextTests {

	@Autowired
	ApplicationContext context;

	@Test
	public void f() {
		System.out.println(context);
	}
}
