package com.endava.tmd.soj.junit5.p06.s2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Rescrieti testul care verifica valoarea sumei a doua numere din tema precedenta
// folosind un fisier (Comma-Separated Value) care sa stocheze datele necesare pentru test
// Fisierul se va numi "sumCheckArguments.csv" si va fi creat in folderul src/test/resources
// Se va utiliza adnotarea @CsvFileSource.
// 
// Testul care verifica exceptiile generate se va copia din tema precedenta
@DisplayName("Parameterized test from CSV file")
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + {1}")
    @DisplayName("Parameterized test of sum with values provided from CSV")
    @CsvFileSource(resources = "/sumCheckArguments.csv")
    void testSumWithValidArguments2(int a, int b, int expected) { assertThat(sum(a, b)).isEqualTo(expected);}


    @DisplayName("parametrized Test Of Sum With Invalid Arguments")
    @ParameterizedTest(name = "{0} + {1} \u21D2 Overflow")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            x,           y
            2147483647,  1
            -2147483648,-1
            """)
    void testSumWithInvalidArguments(int a, int b){
        assertThatThrownBy(()->sum(a,b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
