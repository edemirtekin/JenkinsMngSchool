package utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {
    public static <T> T convertJsonToJava(String json, Class<T> cls) throws JsonProcessingException {//Generic Method


            return new ObjectMapper().readValue(json, cls);


    }
}
