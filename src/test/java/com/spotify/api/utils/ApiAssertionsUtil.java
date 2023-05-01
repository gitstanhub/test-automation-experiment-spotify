package com.spotify.api.utils;

import org.assertj.core.api.Assertions;

public class ApiAssertionsUtil {

    public ApiAssertionsUtil verifyFieldValue(Object field, String expectedValue) {
        Assertions.assertThat(field).isEqualTo(expectedValue);
        return this;
    }
}
