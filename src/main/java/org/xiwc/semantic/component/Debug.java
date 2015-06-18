package org.xiwc.semantic.component;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component
public class Debug {

	public String toJson(Object obj) {

		try {

			String json = JSON.toJSONString(obj, true);

			System.out.println(json);

			return json;

		} catch (Exception e) {

			e.printStackTrace();

			return e.getMessage();
		}
	}

}
