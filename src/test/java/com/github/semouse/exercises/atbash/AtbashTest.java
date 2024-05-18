package com.github.semouse.exercises.atbash;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AtbashTest {

    private final Atbash atbash = new Atbash();

    @Test
    void testEncodeYes() {
        assertThat(atbash.encode("yes")).isEqualTo("bvh");
    }


    @Test
    void testEncodeNo() {
        assertThat(atbash.encode("no")).isEqualTo("ml");
    }


    @Test
    void testEncodeOmgInCapital() {
        assertThat(atbash.encode("OMG")).isEqualTo("lnt");
    }


    @Test
    void testEncodeOmgWithSpaces() {
        assertThat(atbash.encode("O M G")).isEqualTo("lnt");
    }


    @Test
    void testEncodeMindBlowingly() {
        assertThat(atbash.encode("mindblowingly")).isEqualTo("nrmwy oldrm tob");
    }


    @Test
    void testEncodeNumbers() {
        assertThat(atbash.encode("Testing,1 2 3, testing."))
                .isEqualTo("gvhgr mt123 gvhgr mt");
    }


    @Test
    void testEncodeDeepThought() {
        assertThat(atbash.encode("Truth is fiction."))
                .isEqualTo("gifgs rhurx grlm");
    }


    @Test
    void testEncodeAllTheLetters() {
        assertThat(atbash.encode("The quick brown fox jumps over the lazy dog."))
                .isEqualTo("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt");
    }


    @Test
    void testDecodeExercism() {
        assertThat(atbash.decode("vcvix rhn")).isEqualTo("exercism");
    }


    @Test
    void testDecodeASentence() {
        assertThat(atbash.decode("zmlyh gzxov rhlug vmzhg vkkrm thglm v"))
                .isEqualTo("anobstacleisoftenasteppingstone");
    }


    @Test
    void testDecodeNumbers() {
        assertThat(atbash.decode("gvhgr mt123 gvhgr mt"))
                .isEqualTo("testing123testing");
    }


    @Test
    void testDecodeAllTheLetters() {
        assertThat(atbash.decode("gsvjf rxpyi ldmul cqfnk hlevi gsvoz abwlt"))
                .isEqualTo("thequickbrownfoxjumpsoverthelazydog");
    }


    @Test
    void testDecodeWithTooManySpaces() {
        assertThat(atbash.decode("vc vix    r hn")).isEqualTo("exercism");
    }


    @Test
    void testDecodeWithNoSpaces() {
        assertThat(atbash.decode("zmlyhgzxovrhlugvmzhgvkkrmthglmv"))
                .isEqualTo("anobstacleisoftenasteppingstone");
    }

}