package com.spotify.utils.assertions;

import com.spotify.testdata.commons.assertions.AssertionData;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class ApiAssertionsUtil {

    public ApiAssertionsUtil assertAllFieldsContainExpectedText(List<String> actualResponseFieldsValue, String expectedValue) {
        for (String fieldValue : actualResponseFieldsValue) {
            Assertions.assertThat(fieldValue).contains(expectedValue);
        }
        return this;
    }

    public ApiAssertionsUtil assertAnyFieldContainsExpectedText(List<String> actualResponseFieldsValue, String expectedValue) {
        Assertions.assertThat(actualResponseFieldsValue).contains(expectedValue);
        return this;
    }

    public <T> ApiAssertionsUtil assertFieldEqualsTo(T actualValue, T expectedValue) {
        Assertions.assertThat(actualValue).isEqualTo(expectedValue);
        return this;
    }

    public ApiAssertionsUtil assertFieldsAreEqual(Map<Object, Object> actualAndExpectedValue) {
        for (Map.Entry<Object, Object> entry : actualAndExpectedValue.entrySet()) {
            Object actualValue = entry.getKey();
            Object expectedValue = entry.getValue();
            assertFieldEqualsTo(actualValue, expectedValue);
        }
        return this;
    }

    public ApiAssertionsUtil assertFieldsAreEqual(List<Object> actualValue, List<Object> expectedValue) {
        if (actualValue.size() == expectedValue.size()) {
            for (int i = 0; i < actualValue.size(); i++) {
                assertFieldEqualsTo(actualValue.get(i), expectedValue.get(i));
            }
        } else {
            throw new IllegalArgumentException("Amount of actual and expected elements doesn't match");
        }
        return this;
    }

    public ApiAssertionsUtil assertFieldsAreEqual(AssertionData.ActualAssertionData actualValue, AssertionData.ExpectedAssertionData expectedValue) {
        if (actualValue.toList().size() == expectedValue.toList().size()) {
            for (int i = 0; i < actualValue.toList().size(); i++) {
                assertFieldEqualsTo(actualValue.toList().get(i), expectedValue.toList().get(i));
            }
        } else {
            throw new IllegalArgumentException("Amount of actual and expected elements doesn't match");
        }
        return this;
    }
}
