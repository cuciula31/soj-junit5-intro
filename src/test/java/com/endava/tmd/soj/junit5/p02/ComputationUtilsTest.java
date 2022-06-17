package com.endava.tmd.soj.junit5.p02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"

@DisplayName("Tests for my sum method")
class  ComputationUtilsTest {

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

}
