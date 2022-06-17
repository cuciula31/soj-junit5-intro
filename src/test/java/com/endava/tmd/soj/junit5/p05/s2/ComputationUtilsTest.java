package com.endava.tmd.soj.junit5.p05.s2;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
class ComputationUtilsTest {
    @DisplayName("0 + 0 = 0")
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @DisplayName("7 + 0 = 7")
    @Test
    void zeroShouldNotChangePositive() {
        // JUnit Assertion
        assertEquals(7, sum(7, 0));
        // AssertJ Assertion
        //assertThat(sum(7, 0)).isEqualTo(7);
    }

    @DisplayName("-7 + 0 = -7")
    @Test
    void zeroShouldNotChangeNegative() {
        // JUnit Assertion
        assertEquals(-7, sum(-7, 0));
        // AssertJ Assertion
        //assertThat(sum(-7, 0)).isEqualTo(-7);
    }

    @DisplayName("7 + 1 = 8")
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        // JUnit Assertion
        assertEquals(8, sum(7, 1));
        // AssertJ Assertion
        //assertThat(sum(7, 1)).isEqualTo(8);
    }

    @DisplayName("-7 + (-1)) = -8")
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        // JUnit Assertion
        assertEquals(-8, sum(-7, -1));
        // AssertJ Assertion
        //assertThat(sum(-7, -1)).isEqualTo(-8);
    }

    @DisplayName("7 + (-1) = 6")
    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        // JUnit Assertion
        assertEquals(6, sum(7, -1));
        // AssertJ Assertion
        //assertThat(sum(7, -1)).isEqualTo(6);
    }

    @DisplayName("-7 + 1 = -6")
    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        // JUnit Assertion
        assertEquals(-6, sum(-7, 1));
        // AssertJ Assertion
        // assertThat(sum(-7, 1)).isEqualTo(-6);

        //FAIL
        //assertThat(sum(-7, -1)).isEqualTo(-6);

    }

    @DisplayName("MAX_INT + 0 = MAX_INT")
    @Test
    void zeroShouldNotChangeMaxInt() {

        assertEquals(Integer.MAX_VALUE, sum(Integer.MAX_VALUE, 0));

    }

    @DisplayName("MAX_INT + (-1) = MAX_INT-1")
    @Test
    void maxIntAndANegativeNumber() {
        assertEquals(Integer.MAX_VALUE - 1, sum(Integer.MAX_VALUE, -1));
    }

    @DisplayName("MIN_INT + 0 = MIN_INT")
    @Test
    void zeroShouldNotChangeMinInt() {
        assertEquals(Integer.MIN_VALUE, sum(Integer.MIN_VALUE, 0));
    }

    @DisplayName("MIN_INT + 1 = MIN_INT+1")
    @Test
    void minIntAndAPositiveNumber() {
        assertEquals(Integer.MIN_VALUE + 1, sum(Integer.MIN_VALUE, 1));
    }

    @DisplayName("MAX_INT + MIN_INT = -1")
    @Test
    void minIntAndMaxInt() {
        assertEquals(-1, sum(2147483647, -2147483648));
    }

    @Disabled
    @DisplayName("MAX_INT + 1 = ERR")
    @Test
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertEquals(-1, sum(2147483647, 1));
    }

    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
//         JUnit way of checking the exception class
        //assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

//         JUnit way of checking the exception class and its characteristics
        //ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        // assertEquals("Overflow while computing the sum", exception.getMessage());

//         AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    //    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        assertThatThrownBy(() -> sum(-2147483648, -5))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");

    }
}
