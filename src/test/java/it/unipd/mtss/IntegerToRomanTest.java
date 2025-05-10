////////////////////////////////////////////////////////////////////
// Felician Mario Necsulescu 2111935
// Niccolò Feltrin 2111947
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class IntegerToRomanTest {

    private final int input;
    private final String expected;

    public IntegerToRomanTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1, "I"},
                {2, "II"},
                {3, "III"},
                {4, "IV"},
                {5, "V"},
                {6, "VI"},
                {7, "VII"},
                {8, "VIII"},
                {9, "IX"},
                {10, "X"},
                {14, "XIV"},
                {16, "XVI"},
                {19, "XIX"},
                {20, "XX"},
                {30, "XXX"},
                {40, "XL"},
                {50, "L"},
                {60, "LX"},
                {70, "LXX"},
                {80, "LXXX"},
                {90, "XC"},
                {100, "C"}
        });
    }

    @Test
    public void testConvert() {
        // Esegue la funzione di conversione
        String result = IntegerToRoman.convert(input);

        // Verifica se la funzione di conversione ha restituito il valore atteso
        assertEquals(expected, result);
    }
}