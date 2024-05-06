package com.demo.config;

import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.demo.model.Password;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyJacksonTypeHandler extends JacksonTypeHandler {

    private ObjectMapper objectMapper = new ObjectMapper();

    public MyJacksonTypeHandler(Class<?> type) {
        super(type);
    }

    @Override
    protected Object parse(String json) {
        try {
            return objectMapper.readValue(json, Password.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String toJson(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
