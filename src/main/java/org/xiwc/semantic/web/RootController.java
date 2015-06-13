package org.xiwc.semantic.web;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiwc.semantic.model.RespBody;

@Controller
@RequestMapping()
public class RootController {

	static Logger logger = LoggerFactory.getLogger(RootController.class);

	@Autowired
	Environment env;

	@RequestMapping()
	String index(ModelMap modelMap) {

		logger.debug("index page.");

		return "index";
	}

	@RequestMapping("loginUser")
	@ResponseBody
	RespBody loginUser(@AuthenticationPrincipal Principal principal) {

		return RespBody.succeed(principal);
	}
}
