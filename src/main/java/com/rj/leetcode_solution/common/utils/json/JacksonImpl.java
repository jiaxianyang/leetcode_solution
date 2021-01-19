package com.rj.leetcode_solution.common.utils.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

class JacksonImpl implements SpringJson {
    /**
     * jackson 对象
     */
    private ObjectMapper objectMapper;

    /**
     * jackson 初始化
     * 1.日期时间格式化
     */
    public JacksonImpl() {
        objectMapper = new ObjectMapper()
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        JavaTimeModule timeModule = new JavaTimeModule();
        timeModule.addSerializer(LocalDateTime.class, new JsonSerializer<LocalDateTime>(){
            @Override
            public void serialize(LocalDateTime value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String time = df.format(value);
                gen.writeString(time);
            }
        });
        timeModule.addDeserializer(LocalDateTime.class, new JsonDeserializer<LocalDateTime>(){
            @Override
            public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
                String time = p.getText();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                return LocalDateTime.parse(time, df);
            }
        });
        objectMapper.registerModule(timeModule);
        objectMapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public <T> T parseObject(String json, Class<T> clazz) {
        T t = null;
        try {
            t = objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    @Override
    public <T> T parseObject(String json, Type type) {
        JavaType javaType = parseJavaType(type);
        T t = null;
        try {
            t = objectMapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return t;
    }

    @Override
    public <T> List<T> parseArray(String json, Class<T> clazz) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
        List<T> list = null;
        try {
            list = objectMapper.readValue(json, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public String toJsonString(Object object) {
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonString;
    }


    /**
     * 获取type的关联类型
     *
     * @param type
     * @return
     */
    private List<Class<?>> parseGenericType(Type type) {
        List<Class<?>> rootList = new ArrayList<>();
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            rootList.add((Class<?>) pType.getRawType());
            for (Type at : pType.getActualTypeArguments()) {
                List<Class<?>> childList = parseGenericType(at);
                rootList.addAll(childList);
            }
        } else {
            rootList.add((Class<?>) type);
        }
        return rootList;
    }

    /**
     * 类型转换Jackson类型
     *
     * @param genericParameterType
     * @return
     */
    private JavaType parseJavaType(Type genericParameterType) {
        List<Class<?>> list = parseGenericType(genericParameterType);
        if (list == null || list.size() == 1) {
            return objectMapper.getTypeFactory().constructType(genericParameterType);
        }
        Class<?>[] classes = list.toArray(new Class[0]);
        Class<?>[] paramClasses = new Class[classes.length - 1];
        System.arraycopy(classes, 1, paramClasses, 0, paramClasses.length);
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(classes[0], paramClasses);
        return javaType;
    }
}
