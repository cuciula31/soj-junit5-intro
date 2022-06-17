package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @MethodSource("validArguments")
    void testSumWithValidArguments(int a, int b, int expectedSum){
        assertThat(sum(a,b)).isEqualTo(expectedSum);
    }

    @ParameterizedTest(name = "{0} + {1} \u21D2")
    @MethodSource("invalidArguments")
    void testSumWithInvalidArguments(int a, int b){
        assertThatThrownBy(()->sum(a,b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    static List<Arguments> validArguments(){
        return List.of(
                Arguments.arguments(0,0,0),
                Arguments.arguments(0,3,3),
                Arguments.arguments(0,-3,-3),
                Arguments.arguments(5,7,12),
                Arguments.arguments(-5,-7,-12),
                Arguments.arguments(5,-7,-2),
                Arguments.arguments(Integer.MAX_VALUE,0, Integer.MAX_VALUE),
                Arguments.arguments(Integer.MAX_VALUE,-1,2147483646),
                Arguments.arguments(Integer.MIN_VALUE,0, Integer.MIN_VALUE),
                Arguments.arguments(Integer.MIN_VALUE,+1,-2147483647),
                Arguments.arguments(Integer.MIN_VALUE, Integer.MAX_VALUE,-1)
                );
    }

    static List<Arguments> invalidArguments(){
         return List.of(
                 Arguments.arguments(Integer.MAX_VALUE, 1),
                 Arguments.arguments(Integer.MIN_VALUE, -1)
         );
    }

}
