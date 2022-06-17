package com.endava.tmd.soj.junit5.p04;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema de la p02, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare. La ultima metoda, in cazul in care testul nu trece,
// adaugati adnotarea necesara astfel incat sa apara ca si "skipped"
@DisplayName("Test for @Disabled")
class ComputationUtilsTest {

    @DisplayName("0 + 0 = 0")
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
//        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @DisplayName("7 + 0 = 7")
    @Test
    void zeroShouldNotChangePositive() {
        // JUnit Assertion
//        assertEquals(7, sum(7, 0));
        // AssertJ Assertion
        assertThat(sum(7, 0)).isEqualTo(7);
    }

    @DisplayName("-7 + 0 = -7")
    @Test
    void zeroShouldNotChangeNegative() {
        // JUnit Assertion
//        assertEquals(-7, sum(-7, 0));
        // AssertJ Assertion
        assertThat(sum(-7, 0)).isEqualTo(-7);
    }

    @DisplayName("7 + 1 = 8")
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(8, sum(7, 1));
        // AssertJ Assertion
        assertThat(sum(7, 1)).isEqualTo(8);
    }

    @DisplayName("-7 + (-1)) = -8")
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        // JUnit Assertion
//        assertEquals(-8, sum(-7, -1));
        // AssertJ Assertion
        assertThat(sum(-7, -1)).isEqualTo(-8);
    }

    @DisplayName("7 + (-1) = 6")
    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(6, sum(7, -1));
        // AssertJ Assertion
        assertThat(sum(7, -1)).isEqualTo(6);
    }

    @DisplayName("-7 + 1 = -6")
    @Test
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        // JUnit Assertion
//        assertEquals(-6, sum(-7, 1));
        // AssertJ Assertion
         assertThat(sum(-7, 1)).isEqualTo(-6);

        //FAIL
        //assertThat(sum(-7, -1)).isEqualTo(-6);

    }

    @DisplayName("MAX_INT + 0 = MAX_INT")
    @Test
    void zeroShouldNotChangeMaxInt() {

//        assertEquals(Integer.MAX_VALUE,sum(Integer.MAX_VALUE,0));

        assertThat(sum(Integer.MAX_VALUE,0)).isEqualTo(Integer.MAX_VALUE);

    }

    @DisplayName("MAX_INT + (-1) = MAX_INT-1")
    @Test
    void maxIntAndANegativeNumber() {
//        assertEquals(Integer.MAX_VALUE-1,sum(Integer.MAX_VALUE,-1));

        assertThat(sum(Integer.MAX_VALUE,-1)).isEqualTo(2147483646);
    }

    @DisplayName("MIN_INT + 0 = MIN_INT")
    @Test
    void zeroShouldNotChangeMinInt() {
//        assertEquals(Integer.MIN_VALUE,sum(Integer.MIN_VALUE,0));

        assertThat(sum(Integer.MIN_VALUE,0)).isEqualTo(Integer.MIN_VALUE);

    }

    @DisplayName("MIN_INT + 1 = MIN_INT+1")
    @Test
    void minIntAndAPositiveNumber() {
        assertThat(sum(Integer.MIN_VALUE,1)).isEqualTo(-2147483647);

    }

    @DisplayName("MAX_INT + MIN_INT = -1")
    @Test
    void minIntAndMaxInt() {
        assertThat(sum(2147483647,-2147483648)).isEqualTo(-1);
    }

    @Disabled
    @DisplayName("MAX_INT + 1 = ERR")
    @Test
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(2147483647,1)).isEqualTo(2147483648L);
    }

}
