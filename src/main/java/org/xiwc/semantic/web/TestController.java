package org.xiwc.semantic.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.xiwc.semantic.util.JsonUtil;
import org.xiwc.semantic.util.MapUtil;

@Controller
@RequestMapping("test")
public class TestController {

	static Logger logger = LoggerFactory.getLogger(TestController.class);

	@Autowired
	Environment env;

	@RequestMapping("list")
	@ResponseBody
	String index(@RequestParam("id") String id,
			@RequestParam("callback") String callback) {

		logger.debug("list page.");

		logger.info("request param id: {}", id);
		logger.info("request param callback: {}", callback);

		List<Map<String, Object>> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(MapUtil.objArr2Map("id", i, "name", "Zhang San" + i,
					"age", 20 + i, "birth", new Date()));
		}

		return String.format("%s(%s)", callback, JsonUtil.toJson(list));
	}

	@RequestMapping(value = "jsonp/obj", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	String jsonpObj(@RequestParam("callback") String callback) {

		logger.debug("jsonp page.");

		logger.info("request param callback: {}", callback);

		return String.format("%s(%s)", callback, JsonUtil.toJson(MapUtil
				.objArr2Map("id", 0, "name", "Zhang San", "age", 20, "birth",
						new Date())));
	}

	@RequestMapping(value = "jsonp/arr", method = { RequestMethod.GET,
			RequestMethod.POST })
	@ResponseBody
	String jsonpArray(@RequestParam("callback") String callback) {

		logger.debug("jsonp page.");

		logger.info("request param callback: {}", callback);

		List<Map<String, Object>> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add(MapUtil.objArr2Map("id", i, "name", "Zhang San" + i,
					"age", 20 + i, "birth", new Date()));
		}

		return String.format("%s(%s)", callback, JsonUtil.toJson(list));
	}
}
