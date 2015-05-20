package org.xiwc.semantic.util;

import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

/**
 * To create the json string params using chain model. eg:
 * 
 * JsonParam.createObj().obj("params").prop("name",
 * "jhon").obj("child").prop("name", "jhon son") .parent().parent().prop("p1",
 * "v1").obj("o1").prop("p2", "v2").parent().child("params") .prop("p3",
 * "v3").root().prop("p4", "v4").body();
 * 
 * output:
 * {"params":{"name":"jhon","child":{"name":"jhon son"},"p3":"v3"},"p1":"v1",
 * "o1":{"p2":"v2"},"p4":"v4"}
 * 
 * JsonParam.createArr().obj().prop("p1", "v1").obj("o2").prop("p2",
 * "v2").parent
 * ().parent().add("sss").arr().add(10).root().add(true).obj().prop("p3",
 * "v3").parent().child(2).add(false).body();
 * 
 * output: [{"p1":"v1","o2":{"p2":"v2"}},"sss",[10,false],true,{"p3":"v3"}]
 * 
 * @author weichx
 * 
 * @date May 18, 2015 1:34:14 PM
 * 
 */
public final class JsonParam {

	private JsonElement body;

	private JsonElement current;

	private JsonParam(JsonElement body) {
		this.body = body;
		current = body;
	}

	public static JsonParam createObj() {
		return new JsonParam(new JsonObject());
	}

	public static JsonParam createArr() {
		return new JsonParam(new JsonArray());
	}

	public JsonParam obj(String name) {

		if (current instanceof JsonObject) {

			JsonObject obj = new JsonObject();
			((JsonObject) current).add(name, obj);

			// set current operation jsonobject
			current = obj;
		} else {
			throw new RuntimeException(String.format("Invalid operation: obj(\"%s\")", name));
		}

		return this;

	}

	public JsonParam obj() {

		if (current instanceof JsonArray) {
			JsonObject obj = new JsonObject();
			((JsonArray) current).add(obj);

			// set current operation jsonobject
			current = obj;
		} else {
			throw new RuntimeException("Invalid operation: obj()");
		}

		return this;

	}

	public JsonParam arr(String name) {

		if (current instanceof JsonObject) {

			JsonArray arr = new JsonArray();
			((JsonObject) current).add(name, arr);

			// set current operation jsonobject
			current = arr;
		} else {
			throw new RuntimeException(String.format("Invalid operation: arr(\"%s\")", name));
		}

		return this;
	}

	public JsonParam arr() {

		if (current instanceof JsonArray) {
			JsonArray arr = new JsonArray();
			((JsonArray) current).add(arr);

			// set current operation jsonobject
			current = arr;
		} else {
			throw new RuntimeException("Invalid operation: arr()");
		}

		return this;
	}

	public JsonParam add(Object value) {

		if (!(current instanceof JsonArray)) {
			throw new RuntimeException(String.format("Invalid operation: add(%s)",
					((value instanceof String || value instanceof Character) ? String.format("\"%s\"", value) : value)));
		}

		if (value instanceof Boolean) {
			((JsonArray) current).add(new JsonPrimitive((Boolean) value));
		} else if (value instanceof String) {
			((JsonArray) current).add(new JsonPrimitive((String) value));
		} else if (value instanceof Character) {
			((JsonArray) current).add(new JsonPrimitive((Character) value));
		} else if (value instanceof Number) {
			((JsonArray) current).add(new JsonPrimitive((Number) value));
		} else {
			((JsonArray) current).add(new JsonPrimitive((String) value));
		}

		return this;
	}

	public JsonParam prop(String name, Object value) {

		if (!(current instanceof JsonObject)) {
			throw new RuntimeException(String.format("Invalid operation: prop(\"%s\", %s)", name,
					((value instanceof String || value instanceof Character) ? String.format("\"%s\"", value) : value)));
		}

		if (value instanceof Boolean) {
			((JsonObject) current).addProperty(name, (Boolean) value);
		} else if (value instanceof String) {
			((JsonObject) current).addProperty(name, (String) value);
		} else if (value instanceof Character) {
			((JsonObject) current).addProperty(name, (Character) value);
		} else if (value instanceof Number) {
			((JsonObject) current).addProperty(name, (Number) value);
		} else {
			((JsonObject) current).addProperty(name, String.valueOf(value));
		}

		return this;
	}

	public JsonParam root() {
		current = body;
		return this;
	}

	private JsonElement getCurrentParent(JsonElement element) {

		if (element instanceof JsonObject) {
			for (Map.Entry<String, JsonElement> entry : ((JsonObject) element).entrySet()) {
				if (entry.getValue() == current) {
					return element;
				} else {
					if (getCurrentParent(entry.getValue()) != null) {
						return entry.getValue();
					}
				}
			}
		} else if (element instanceof JsonArray) {
			for (JsonElement jsonElement : (JsonArray) element) {
				if (jsonElement == current) {
					return element;
				} else {
					if (getCurrentParent(jsonElement) != null) {
						return jsonElement;
					}
				}
			}
		}

		return null;
	}

	public JsonParam parent() {

		if (current == body) {
			throw new RuntimeException(
					String.format("Invalid operation: parent(), message: Current is Root, no parent."));
		} else {
			JsonElement parent = getCurrentParent(body);
			if (parent != null) {
				current = parent;
			} else {
				throw new RuntimeException(String.format("Invalid operation: parent(), message: parent not found."));
			}
			return this;
		}
	}

	public JsonParam child(String name) {

		if (!(current instanceof JsonObject)) {
			throw new RuntimeException(String.format("Invalid operation: child(\"%s\")", name));
		}

		for (Map.Entry<String, JsonElement> entry : ((JsonObject) current).entrySet()) {
			if (name.equals(entry.getKey())
					&& (entry.getValue() instanceof JsonObject || entry.getValue() instanceof JsonArray)) {
				current = entry.getValue();
				break;
			}
		}

		return this;
	}

	public JsonParam child(int index) {

		if (!(current instanceof JsonArray)) {
			throw new RuntimeException(String.format("Invalid operation: child(%s)", index));
		}

		JsonArray array = (JsonArray) current;

		if (index < array.size()) {
			JsonElement jsonElement = array.get(index);

			if (jsonElement instanceof JsonArray || jsonElement instanceof JsonObject) {
				current = jsonElement;
			}
		}

		return this;
	}

	public String body() {
		return body.toString();
	}

	public JsonElement jsonBody() {
		return body;
	}
}
