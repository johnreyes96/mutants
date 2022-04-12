package com.meli.Mutants.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {

    @Test
    public void isEmptyWhenArrayIsNullThenMustReturnTrueTest() {
        String[] array = null;

        boolean result = StringUtils.isEmpty(array);

        Assertions.assertTrue(result);
    }

    @Test
    public void isEmptyWhenArrayHaveNotItemsThenMustReturnTrueTest() {
        String[] array = new String[0];

        boolean result = StringUtils.isEmpty(array);

        Assertions.assertTrue(result);
    }

    @Test
    public void isEmptyWhenArrayHaveItemsThenMustReturnFalseTest() {
        String[] array = new String[1];
        array[0] = "ATGCGA";

        boolean result = StringUtils.isEmpty(array);

        Assertions.assertFalse(result);
    }
}
