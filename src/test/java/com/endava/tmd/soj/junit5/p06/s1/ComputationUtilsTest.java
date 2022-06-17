package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
@DisplayName("Parameterized tests")
class ComputationUtilsTest {




    @ParameterizedTest(name = "{0} + {1} = {2}")
    @DisplayName("parametrized Test Of Sum With Valid Arguments")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """  
            x,         y,          x+y
            0,         0,           0
            0,         3,           3
            0,        -3,          -3
            5,         7,           12
           -5,        -7,          -12
           -5,         7,           2
            5,        -7,          -2
            2147483647,0,           2147483647
            2147483647,-1,          2147483646
            -2147483648,0,         -2147483648
            -2147483648,1,         -2147483647
            -2147483648,2147483647,-1
            """)
    void testSumWithValidArguments(int a, int b, int expected) { assertThat(sum(a, b)).isEqualTo(expected);}

    @DisplayName("parametrized Test Of Sum With Invalid Arguments")
    @ParameterizedTest(name = "{0} + {1} \u21D2 Overflow")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
            x,           y
            2147483647,  1
            -2147483648,-1
            """)
    void




    testSumWithInvalidArguments(int a, int b){
        assertThatThrownBy(()->sum(a,b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
}
