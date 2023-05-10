package com.spotify.utils;

import org.assertj.core.api.Assertions;

import java.util.Map;

public class ApiAssertionsUtil {

    public ApiAssertionsUtil verifyResponseSingleField(Object actualValue, Object expectedValue) {
        Assertions.assertThat(actualValue).isEqualTo(expectedValue);
        return this;
    }

    public ApiAssertionsUtil verifyResponseMultipleFields(Map<Object, Object> actualAndExpectedValues) {
        for (Map.Entry<Object, Object> entry : actualAndExpectedValues.entrySet()) {
            Object actualValue = entry.getKey();
            Object expectedValue = entry.getValue();
            verifyResponseSingleField(actualValue, expectedValue);
        }
        return this;
    }
}
