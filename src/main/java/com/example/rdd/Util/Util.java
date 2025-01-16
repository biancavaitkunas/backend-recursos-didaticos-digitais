package com.example.rdd.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Util {

    public static <T> T convertJson(final String json, final Class<T> clazz) {
        final var objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> convertJsonToList(final String json, final Class<T> clazz) {
        final var objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, objectMapper.getTypeFactory().constructCollectionType(List.class, clazz));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean isPresent(final Object object) {
        return object != null;
    }

    public static boolean isEmpty(final Object object) {
        return object == null;
    }

}
