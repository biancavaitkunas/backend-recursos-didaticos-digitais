package com.example.rdd.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.regex.Pattern;

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

    public static String convertToEmbedUrl(final String url) {
        final var regex = "(?:\\?v=|/embed/|/v/|/watch\\?v=|&v=|youtu\\.be/|/shorts/|/live/|/e/|/u/\\w/|embed/|v%3D|/vi/|/v%3D|watch\\?v%3D|&v%3D)([^#&?]*)";
        final var pattern = Pattern.compile(regex);
        final var matcher = pattern.matcher(url);

        return matcher.find()  ? "https://www.youtube.com/embed/" + matcher.group(1) : url;
    }

}
