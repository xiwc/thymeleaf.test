package org.xiwc.semantic.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.xiwc.semantic.entity.Test;
import org.xiwc.semantic.entity.TestRepository;
import org.xiwc.semantic.model.RespBody;

@Controller
@RequestMapping("page")
public class PageController {

	@Autowired
	TestRepository testRepository;

	@RequestMapping("test")
	String test(ModelMap modelMap) {

		testRepository.findAll().forEach(System.out::println);

		modelMap.addAttribute("test", testRepository.findOne(1L));
		modelMap.addAttribute("tests", testRepository.findAll());

		return "test";
	}

	@RequestMapping("submit")
	String submit(Test test, ModelMap modelMap) {

		modelMap.addAttribute("test", testRepository.save(test));
		modelMap.addAttribute("tests", testRepository.findAll());

		return "test";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	@ResponseBody
	public RespBody upload(HttpServletRequest request,
			HttpServletResponse response, Model model, Locale locale,
			@RequestParam("multiple") MultipartFile file) {

		return new RespBody(true);
	}
}
