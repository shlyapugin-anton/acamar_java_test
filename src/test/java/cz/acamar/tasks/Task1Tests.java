package cz.acamar.tasks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Tests {

    private Task1 task1 = new Task1();

    @ParameterizedTest
    @MethodSource("stringsAndLastWordLength")
    void test_lastWordLength(String str, int lastWordLength) {
        assertEquals(lastWordLength, task1.lengthOfLastWord(str));
    }

    private static Stream<Arguments> stringsAndLastWordLength() {
        return Stream.of(
                Arguments.of("Hello world", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("William Shakespeare was an English   playwright", 10),
                Arguments.of("     ", 0),                // ADD new case: empty string has length 0
                Arguments.of("          flaaa  ", 5)     // and another case with just one word and some spaces
        );
    }
}
