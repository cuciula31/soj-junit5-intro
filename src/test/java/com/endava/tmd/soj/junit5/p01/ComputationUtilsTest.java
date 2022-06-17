package com.endava.tmd.soj.junit5.p01;

// Provocari:
// 1. Adaugati adnotarea neecesara pentru a rula prima metoda ca si un test unitar
// 2. Rulati prima metoda ca si un test unitar
// 3. Decomentati asertiile din primul test, si efectuati importurile necesare. Rulati testul din nou.
// 4. Adaugati o linie care sa determine testul sa fie "failed". La sfarsit commentati acea linie
// 5. Completati celelalte metode astfel incat sa reprezinte scenarii de testare

import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComputationUtilsTest {

    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        //assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @Test
    void zeroShouldNotChangePositive() {
        // JUnit Assertion
        //assertEquals(7, sum(7, 0));
        // AssertJ Assertion
        assertThat(sum(7, 0)).isEqualTo(7);
    }

    @Test
    void zeroShouldNotChangeNegative() {
        // JUnit Assertion
//        assertEquals(-7, sum(-7, 0));
        // AssertJ Assertion
        assertThat(sum(-7, 0)).isEqualTo(-7);
    }

    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(8, sum(7, 1));
        // AssertJ Assertion
        assertThat(sum(7, 1)).isEqualTo(8);
    }

    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        // JUnit Assertion
//        assertEquals(-8, sum(-7, -1));
        // AssertJ Assertion
        assertThat(sum(-7, -1)).isEqualTo(-8);
    }

    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(6, sum(7, -1));
        // AssertJ Assertion
        assertThat(sum(7, -1)).isEqualTo(6);
    }

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
