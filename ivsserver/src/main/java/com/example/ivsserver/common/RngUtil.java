package com.example.ivsserver.common;


import static org.apache.commons.lang3.RandomStringUtils.random;

public class RngUtil {

    public static String randomAlphabetic() {
        return random(10, true, false);
    }
}
