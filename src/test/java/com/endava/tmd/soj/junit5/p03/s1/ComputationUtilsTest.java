package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Tests for @Order")
class ComputationUtilsTest {

    @Test
    void aZeroShouldNotChangeZero() {
        // JUnit Assertion
//        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @Test
    void eZeroShouldNotChangePositive() {
        // JUnit Assertion
//        assertEquals(7, sum(7, 0));
        // AssertJ Assertion
        assertThat(sum(7, 0)).isEqualTo(7);
    }

    @Test
    void fZeroShouldNotChangeNegative() {
        // JUnit Assertion
//        assertEquals(-7, sum(-7, 0));
        // AssertJ Assertion
        assertThat(sum(-7, 0)).isEqualTo(-7);
    }

    @Test
    void bTwoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(8, sum(7, 1));
        // AssertJ Assertion
        assertThat(sum(7, 1)).isEqualTo(8);
    }

    @Test
    void gTwoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        // JUnit Assertion
//        assertEquals(-8, sum(-7, -1));
        // AssertJ Assertion
        assertThat(sum(-7, -1)).isEqualTo(-8);
    }

    @Test
    void dOneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(6, sum(7, -1));
        // AssertJ Assertion
        assertThat(sum(7, -1)).isEqualTo(6);
    }

    @Test
    void cOneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        // JUnit Assertion
//        assertEquals(-6, sum(-7, 1));
        // AssertJ Assertion
         assertThat(sum(-7, 1)).isEqualTo(-6);

        //FAIL
        //assertThat(sum(-7, -1)).isEqualTo(-6);

    }
}
