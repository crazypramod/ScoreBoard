package com.sample.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.application.exception.ScoreBoardRuntimeException;

import java.io.File;

public class ApplicationUtil {

    public static <T> T json2Java(String fileName, Class<T> classType) {
        File file = new File("src/main/resources/" + fileName);
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            return mapper.readValue(file, classType);
        } catch (Exception e) {
            throw new ScoreBoardRuntimeException("Error occured while trying to convert file to java object: ", e);
        }
    }

    public static <T> String convertObjectToJsonString(T t) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
        } catch (JsonProcessingException e) {
            throw new ScoreBoardRuntimeException("Error occured while trying to parse java object to json string: ", e);
        }
    }

}
