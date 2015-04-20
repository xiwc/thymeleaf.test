package org.xiwc.semantic.component;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class JsonParser {

	public String parse(Object obj) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		return Stream.of(obj.getClass().getDeclaredFields()).map(f -> f.getName()).collect(Collectors.joining(" | "));
	}

}
