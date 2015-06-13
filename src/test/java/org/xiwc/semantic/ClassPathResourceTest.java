package org.xiwc.semantic;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang.ArrayUtils;
import org.testng.annotations.Test;

public class ClassPathResourceTest {

	@Test
	public void test() throws IOException {

		InputStream is = ClassPathResourceTest.class
				.getResourceAsStream("/static/img/img01.jpg");

		byte[] bs = new byte[is.available()];
		is.read(bs);

		System.out.println(ArrayUtils.toString(bs));
	}
}
