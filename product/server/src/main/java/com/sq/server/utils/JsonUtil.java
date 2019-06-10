package com.sq.server.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 对象转Json
 */
public class JsonUtil {

    private static  ObjectMapper objectMapper = new ObjectMapper();

    public static  String toJson(Object object)
    {
        try {
            return  objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
