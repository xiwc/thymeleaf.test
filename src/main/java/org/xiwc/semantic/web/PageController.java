package org.xiwc.semantic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

	@RequestMapping("test")
	String test() {
		return "test";
	}
}
