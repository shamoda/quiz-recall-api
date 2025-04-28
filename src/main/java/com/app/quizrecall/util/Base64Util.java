package com.app.quizrecall.util;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class Base64Util {
    public String encodeInteger(int number) {
        String numberAsString = String.valueOf(number); // Convert int to String
        return Base64.getEncoder().encodeToString(numberAsString.getBytes(StandardCharsets.UTF_8)); // Then Base64
    }

    public int decodeInteger(String encodedString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes, StandardCharsets.UTF_8); // Convert bytes to String
        return Integer.parseInt(decodedString); // Then parse to int
    }


    public String encodeBoolean(boolean value) {
        byte[] byteArray = new byte[]{(byte) (value ? 1 : 0)};
        return Base64.getEncoder().encodeToString(byteArray);
    }

    public boolean decodeBoolean(String encodedString) {
        byte[] decodedByteArray = Base64.getDecoder().decode(encodedString);
        return decodedByteArray[0] != 0;
    }
}
