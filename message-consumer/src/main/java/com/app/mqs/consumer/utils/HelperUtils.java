package com.app.mqs.consumer.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelperUtils {
	
    
	public static Object convertJsonToDTO(String jsonString, Class<?> c) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			return mapper.readValue(jsonString, c);
		} catch (Exception ex) {
			log.error("Exception while Converting DTO to String -> " + ex.getMessage());
			ex.printStackTrace();
		}
		return null;
	}
}
