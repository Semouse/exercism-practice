package com.github.semouse.exercises.bob;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BobTest {
    private final Bob bob = new Bob();
    
    @Test
    void saySomething() {
        assertThat(bob.hey("Tom-ay-to, tom-aaaah-to."))
                .isEqualTo("Whatever.");
    }
    
    @Test
    void shouting() {
        assertThat(bob.hey("WATCH OUT!"))
                .isEqualTo("Whoa, chill out!");
    }
    
    @Test
    void shoutingGibberish() {
        assertThat(bob.hey("FCECDFCAAB"))
                .isEqualTo("Whoa, chill out!");
    }
    
    @Test
    void askingAQuestion() {
        assertThat(bob.hey("Does this cryogenic chamber make me look fat?"))
                .isEqualTo("Sure.");
    }
    
    @Test
    void askingANumericQuestion() {
        assertThat(bob.hey("You are, what, like 15?"))
                .isEqualTo("Sure.");
    }
    
    @Test
    void askingGibberish() {
        assertThat(bob.hey("fffbbcbeab?"))
                .isEqualTo("Sure.");
    }
    
    @Test
    void talkingForcefully() {
        assertThat(bob.hey("Hi there!"))
                .isEqualTo("Whatever.");
    }
    
    @Test
    void usingAcronymsInRegularSpeech() {
        assertThat(bob.hey("It's OK if you don't want to go work for NASA."))
                .isEqualTo("Whatever.");
    }
    
    @Test
    void forcefulQuestions() {
        assertThat(bob.hey("WHAT'S GOING ON?"))
                .isEqualTo("Calm down, I know what I'm doing!");
    }
    
    @Test
    void shoutingNumbers() {
        assertThat(bob.hey("1, 2, 3 GO!"))
                .isEqualTo("Whoa, chill out!");
    }
    
    @Test
    void onlyNumbers() {
        assertThat(bob.hey("1, 2, 3"))
                .isEqualTo("Whatever.");
    }
    
    @Test
    void questionWithOnlyNumbers() {
        assertThat(bob.hey("4?"))
                .isEqualTo("Sure.");
    }
    
    @Test
    void shoutingWithSpecialCharacters() {
        assertThat(bob.hey("ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!"))
                .isEqualTo("Whoa, chill out!");
    }
    
    @Test
    void shoutingWithNoExclamationMark() {
        assertThat(bob.hey("I HATE THE DENTIST"))
                .isEqualTo("Whoa, chill out!");
    }
    
    @Test
    void statementContainingQuestionMark() {
        assertThat(bob.hey("Ending with ? means a question."))
                .isEqualTo("Whatever.");
    }
    
    @Test
    void nonLettersWithQuestion() {
        assertThat(bob.hey(":) ?"))
                .isEqualTo("Sure.");
    }
    
    @Test
    void prattlingOn() {
        assertThat(bob.hey("Wait! Hang on. Are you going to be OK?"))
                .isEqualTo("Sure.");
    }
    
    @Test
    void silence() {
        assertThat(bob.hey(""))
                .isEqualTo("Fine. Be that way!");
    }
    
    @Test
    void prolongedSilence() {
        assertThat(bob.hey("          "))
                .isEqualTo("Fine. Be that way!");
    }
    
    @Test
    void alternateSilence() {
        assertThat(bob.hey("\t\t\t\t\t\t\t\t\t\t"))
                .isEqualTo("Fine. Be that way!");
    }
    
    @Test
    void multipleLineQuestion() {
        assertThat(bob.hey("\nDoes this cryogenic chamber make me look fat?\nNo."))
                .isEqualTo("Whatever.");
    }
    
    @Test
    void startingWithWhitespace() {
        assertThat(bob.hey("         hmmmmmmm..."))
                .isEqualTo("Whatever.");
    }
    
    @Test
    void endingWithWhiteSpace() {
        assertThat(bob.hey("Okay if like my  spacebar  quite a bit?   "))
                .isEqualTo("Sure.");
    }
    
    @Test
    void otherWhiteSpace() {
        assertThat(bob.hey("\n\r \t"))
                .isEqualTo("Fine. Be that way!");
    }
    
    @Test
    void nonQuestionEndingWithWhiteSpace() {
        assertThat(bob.hey("This is a statement ending with whitespace      "))
                .isEqualTo("Whatever.");
    }
}