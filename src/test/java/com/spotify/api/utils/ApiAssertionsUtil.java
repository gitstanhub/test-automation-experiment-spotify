package com.spotify.api.utils;

import org.assertj.core.api.Assertions;

import java.util.Map;

public class ApiAssertionsUtil {

    public ApiAssertionsUtil verifyResponseSingleField(Object field, Object expectedValue) {
        Assertions.assertThat(field).isEqualTo(expectedValue);
        return this;
    }

    public ApiAssertionsUtil verifyResponseMultipleFields(Map<Object, Object> expectedFieldsAndValues) {
        for (Map.Entry<Object, Object> entry : expectedFieldsAndValues.entrySet()) {
            Object expectedField = entry.getKey();
            Object expectedValue = entry.getValue();
            verifyResponseSingleField(expectedField, expectedValue);
        }
        return this;
    }
}
