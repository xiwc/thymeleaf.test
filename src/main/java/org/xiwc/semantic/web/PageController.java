package org.xiwc.semantic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.xiwc.semantic.entity.Test;
import org.xiwc.semantic.entity.TestRepository;

@Controller
@RequestMapping("page")
public class PageController {

	@Autowired
	TestRepository testRepository;

	@RequestMapping("test")
	String test(ModelMap modelMap) {

		testRepository.findAll().forEach(System.out::println);

		modelMap.addAttribute("test", testRepository.findOne(1L));

		return "test";
	}

	@RequestMapping("submit")
	String submit(Test test, ModelMap modelMap) {

		modelMap.addAttribute("test", testRepository.save(test));

		return "test";
	}
}
