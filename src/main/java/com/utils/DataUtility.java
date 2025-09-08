package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataUtility {

	private static ThreadLocal<JsonNode> scenarioData = new ThreadLocal<>();

	public static void loadScenarioData(String scenarioName) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode rootNode = mapper.readTree(new File("src/test/resources/testData/testData.json"));
			JsonNode dataForScenario = rootNode.get(scenarioName);
			scenarioData.set(dataForScenario);
		} catch (IOException e) {
			e.printStackTrace();
			scenarioData.set(null);
		}
	}

	public static JsonNode getScenarioData() {
		return scenarioData.get();
	}

	public static void clear() {
		scenarioData.remove();
	}

	public static String getProperty(String key) {
		Properties properties = new Properties();
		String value = null;
		try {
			properties.load(new FileInputStream("src/test/resources/environment.properties"));
			value = properties.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}
