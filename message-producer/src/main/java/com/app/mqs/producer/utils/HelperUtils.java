package com.app.mqs.producer.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelperUtils {
	
	public String convertDtoToJsonString(Object dto) {
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		String jsonStr = null ;
		try {
			jsonStr = objectMapper.writeValueAsString(dto);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return jsonStr;
	}
}
