package machine.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputParserTest {
    private final InputParser inputParser =  new InputParser();

    @Test
    void shouldParsePositiveInteger(){
        assertEquals(12, inputParser.toPositiveInt("12"));
    }

    @Test
    void shouldReturnZeroForNegativeInteger(){
        assertEquals(0,inputParser.toPositiveInt("-1"));
    }

    @Test
    void shouldReturnZeroForInvalidInput(){
        assertEquals(0,inputParser.toPositiveInt("abc"));
    }
}
