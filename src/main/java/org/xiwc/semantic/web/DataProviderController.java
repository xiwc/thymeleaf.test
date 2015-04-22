package org.xiwc.semantic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xiwc.semantic.entity.TestRepository;
import org.xiwc.semantic.model.ReponseBody;

@RestController
@RequestMapping("dp")
public class DataProviderController {

	@Autowired
	TestRepository testRepository;

	@RequestMapping("test")
	Object test(@RequestParam(value = "flg", required = false, defaultValue = "true") boolean flg) {
		return new ReponseBody(flg, testRepository.findAll());
	}
}
