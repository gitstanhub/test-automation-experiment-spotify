package com.spotify.testdata.commons;

import java.util.List;

public abstract class AssertionData {

    public static abstract class ActualAssertionData {
        public abstract List<Object> toList();
    }

    public static abstract class ExpectedAssertionData {
        public abstract List<Object> toList();
    }
}
