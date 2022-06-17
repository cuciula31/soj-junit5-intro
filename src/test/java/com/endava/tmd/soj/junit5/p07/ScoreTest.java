package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {
    private Score score;
    static Locale currentLocale;

    @BeforeAll
    static void setupLocale(){
        Locale.setDefault(Locale.US);
//        Locale.setDefault(Locale.FRANCE);
        currentLocale = Locale.getDefault();
    }

    @BeforeEach
    void setupScore(){
        score = new Score();
    }

    @Test
    void noAnswer(){
        if (Locale.getDefault().equals(Locale.FRANCE)){
            assertThat(score.getPercent()).isEqualTo("100,0");
        }else{
            assertThat(score.getPercent()).isEqualTo("100.0");
        }
    }

    @Test
    void noneIncorrect(){
        score.addCorrectAnswer();
        if (Locale.getDefault().equals(Locale.FRANCE)){
            assertThat(score.getPercent()).isEqualTo("100,0");
        }else{
            assertThat(score.getPercent()).isEqualTo("100.0");
        }
    }

     @Test
    void oneThird(){
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();

         if (Locale.getDefault().equals(Locale.FRANCE)){
             assertThat(score.getPercent()).isEqualTo("33,3");
         }else{
             assertThat(score.getPercent()).isEqualTo("33.3");
         }
     }
}
