package com.spotify.utils.assertions;

import com.spotify.testdata.commons.assertions.AssertionData;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class ApiAssertionsUtil {

    public ApiAssertionsUtil verifyEachResponseFieldContains(List<String> actualResponseFieldsData, String expectedValue) {
        for (String fieldValue : actualResponseFieldsData) {
            Assertions.assertThat(fieldValue).contains(expectedValue);
        }
        return this;
    }

    public ApiAssertionsUtil verifySomeResponseFieldsContain(List<String> actualResponseFieldsData, String expectedValue) {
        Assertions.assertThat(actualResponseFieldsData).contains(expectedValue);
        return this;
    }

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

    public ApiAssertionsUtil verifyResponseMultipleFields(List<Object> actualData, List<Object> expectedData) {
        if (actualData.size() == expectedData.size()) {
            for (int i = 0; i < actualData.size(); i++) {
                verifyResponseSingleField(actualData.get(i), expectedData.get(i));
            }
        } else {
            throw new IllegalArgumentException("Amount of actual and expected elements doesn't match");
        }
        return this;
    }

    public ApiAssertionsUtil verifyResponseMultipleFields(AssertionData.ActualAssertionData actualData, AssertionData.ExpectedAssertionData expectedData) {
        if (actualData.toList().size() == expectedData.toList().size()) {
            for (int i = 0; i < actualData.toList().size(); i++) {
                verifyResponseSingleField(actualData.toList().get(i), expectedData.toList().get(i));
            }
        } else {
            throw new IllegalArgumentException("Amount of actual and expected elements doesn't match");
        }
        return this;
    }
}
