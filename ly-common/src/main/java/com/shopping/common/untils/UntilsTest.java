package com.shopping.common.untils;

import java.util.Map;

public class UntilsTest {
    public static void main(String[] args) {
        //language=JSON
        String json = "{\n" +
                "  \"name\":\"jack\",\n" +
                "  \"age\": \"21\"\n" +
                "}";
        Map<String, String> map = JsonUtils.parseMap(json, String.class, String.class);
        System.out.println("map = " + map);
    }
}
