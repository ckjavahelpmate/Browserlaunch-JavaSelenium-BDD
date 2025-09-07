package com.utils;

import java.io.File;
import java.io.IOException;

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
}
