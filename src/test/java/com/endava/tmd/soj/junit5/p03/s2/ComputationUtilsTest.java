package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
@DisplayName("Tests @order method")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class  ComputationUtilsTest {

    @DisplayName("7")
    @Order(7)
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
//        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }

    @Order(6)
    @DisplayName("6")
    @Test
    void zeroShouldNotChangePositive() {
        // JUnit Assertion
//        assertEquals(7, sum(7, 0));
        // AssertJ Assertion
        assertThat(sum(7, 0)).isEqualTo(7);
    }

    @Order(1)
    @DisplayName("1")
    @Test
    void zeroShouldNotChangeNegative() {
        // JUnit Assertion
//        assertEquals(-7, sum(-7, 0));
        // AssertJ Assertion
        assertThat(sum(-7, 0)).isEqualTo(-7);
    }

    @Order(2)
    @DisplayName("2")
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(8, sum(7, 1));
        // AssertJ Assertion
        assertThat(sum(7, 1)).isEqualTo(8);
    }

    @Order(3)
    @DisplayName("3")
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        // JUnit Assertion
//        assertEquals(-8, sum(-7, -1));
        // AssertJ Assertion
        assertThat(sum(-7, -1)).isEqualTo(-8);
    }

    @Order(5)
    @DisplayName("5")
    @Test
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        // JUnit Assertion
//        assertEquals(6, sum(7, -1));
        // AssertJ Assertion
        assertThat(sum(7, -1)).isEqualTo(6);
    }

    @Order(4)
    @DisplayName("4")
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
