////////////////////////////////////////////////////////////////////
// Felician Mario Necsulescu 2111935
// Niccolò Feltrin 2111947
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.fail;

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
                {100, "C"},
                {200, "CC"},
                {300, "CCC"},
                {400, "CD"},
                {500, "D"},
                {600, "DC"},
                {700, "DCC"},
                {800, "DCCC"},
                {900, "CM"},
                {1000, "M"},
                {0, null},
                {1001, null}
        });
    }

    @Test
    public void testClassIsInstantiable() {  // Controllo superfluo per avere il 100% di code coverage
        try {
            new IntegerToRoman();
        }catch (Exception e) {
            fail("La classe IntegerToRoman non puo' essere instanziata.");
        }
    }

    @Test
    public void testConvert() {
        try {
            // Esegue la funzione di conversione
            String result = IntegerToRoman.convert(input);

            // Verifica se la funzione di conversione ha restituito il valore atteso
            assertEquals(expected, result);
        } catch (IllegalArgumentException e) {  // Percorso che dovrebbe eseguire con i parametri 0 e 1001
            if(expected != null) {
                fail("Il programma non funziona correttamente con parametri garantiti. (" + input + ")");
            }
        }
    }
}