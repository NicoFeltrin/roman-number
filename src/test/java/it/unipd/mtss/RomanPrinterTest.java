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
public class RomanPrinterTest {

    private final int input;
    private final String expected;

    public RomanPrinterTest(int input, String expected) {
        this.input = input;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {1,"  _____ \n |_   _|\n   | |  \n   | |  \n  _| |_ \n |_____|\n"},
                {2,"  _____   _____ \n |_   _| |_   _|\n   | |     | |  \n   | |     | |  \n  _| |_   _| |_ \n |_____| |_____|\n", },
                {3,"  _____   _____   _____ \n |_   _| |_   _| |_   _|\n   | |     | |     | |  \n   | |     | |     | |  \n  _| |_   _| |_   _| |_ \n |_____| |_____| |_____|\n"},
                {4, "  _____  __      __\n |_   _| \\ \\    / /\n   | |    \\ \\  / / \n   | |     \\ \\/ /  \n  _| |_     \\  /   \n |_____|     \\/    \n"},
                {5, " __      __\n \\ \\    / /\n  \\ \\  / / \n   \\ \\/ /  \n    \\  /   \n     \\/    \n"},
                {6, " __      __  _____ \n \\ \\    / / |_   _|\n  \\ \\  / /    | |  \n   \\ \\/ /     | |  \n    \\  /     _| |_ \n     \\/     |_____|\n"},
                {7," __      __  _____   _____ \n \\ \\    / / |_   _| |_   _|\n  \\ \\  / /    | |     | |  \n   \\ \\/ /     | |     | |  \n    \\  /     _| |_   _| |_ \n     \\/     |_____| |_____|\n"},
                {8," __      __  _____   _____   _____ \n \\ \\    / / |_   _| |_   _| |_   _|\n  \\ \\  / /    | |     | |     | |  \n   \\ \\/ /     | |     | |     | |  \n    \\  /     _| |_   _| |_   _| |_ \n     \\/     |_____| |_____| |_____|\n"},
                {9,"  _____  __   __\n |_   _| \\ \\ / /\n   | |    \\ V / \n   | |     > <  \n  _| |_   / . \\ \n |_____| /_/ \\_\\\n"},
                {10," __   __\n \\ \\ / /\n  \\ V / \n   > <  \n  / . \\ \n /_/ \\_\\\n"},
                {14, " __   __  _____  __      __\n \\ \\ / / |_   _| \\ \\    / /\n  \\ V /    | |    \\ \\  / / \n   > <     | |     \\ \\/ /  \n  / . \\   _| |_     \\  /   \n /_/ \\_\\ |_____|     \\/    \n"},
                {16, " __   __ __      __  _____ \n \\ \\ / / \\ \\    / / |_   _|\n  \\ V /   \\ \\  / /    | |  \n   > <     \\ \\/ /     | |  \n  / . \\     \\  /     _| |_ \n /_/ \\_\\     \\/     |_____|\n"},
                {19, " __   __  _____  __   __\n \\ \\ / / |_   _| \\ \\ / /\n  \\ V /    | |    \\ V / \n   > <     | |     > <  \n  / . \\   _| |_   / . \\ \n /_/ \\_\\ |_____| /_/ \\_\\\n"},
                {20, " __   __ __   __\n \\ \\ / / \\ \\ / /\n  \\ V /   \\ V / \n   > <     > <  \n  / . \\   / . \\ \n /_/ \\_\\ /_/ \\_\\\n"},
                {30," __   __ __   __ __   __\n \\ \\ / / \\ \\ / / \\ \\ / /\n  \\ V /   \\ V /   \\ V / \n   > <     > <     > <  \n  / . \\   / . \\   / . \\ \n /_/ \\_\\ /_/ \\_\\ /_/ \\_\\\n"},
                {40," __   __  _      \n \\ \\ / / | |     \n  \\ V /  | |     \n   > <   | |     \n  / . \\  | |____ \n /_/ \\_\\ |______|\n"},
                {50,"  _      \n | |     \n | |     \n | |     \n | |____ \n |______|\n"},
                {60, "  _       __   __\n | |      \\ \\ / /\n | |       \\ V / \n | |        > <  \n | |____   / . \\ \n |______| /_/ \\_\\\n"},
                {70, "  _       __   __ __   __\n | |      \\ \\ / / \\ \\ / /\n | |       \\ V /   \\ V / \n | |        > <     > <  \n | |____   / . \\   / . \\ \n |______| /_/ \\_\\ /_/ \\_\\\n"},
                {80, "  _       __   __ __   __ __   __\n | |      \\ \\ / / \\ \\ / / \\ \\ / /\n | |       \\ V /   \\ V /   \\ V / \n | |        > <     > <     > <  \n | |____   / . \\   / . \\   / . \\ \n |______| /_/ \\_\\ /_/ \\_\\ /_/ \\_\\\n"},
                {90, " __   __   _____ \n \\ \\ / /  / ____|\n  \\ V /  | |     \n   > <   | |     \n  / . \\  | |____ \n /_/ \\_\\  \\_____|\n"},
                {100, "   _____ \n  / ____|\n | |     \n | |     \n | |____ \n  \\_____|\n"},
                {200,"   _____    _____ \n  / ____|  / ____|\n | |      | |     \n | |      | |     \n | |____  | |____ \n  \\_____|  \\_____|\n"},
                {300,"   _____    _____    _____ \n  / ____|  / ____|  / ____|\n | |      | |      | |     \n | |      | |      | |     \n | |____  | |____  | |____ \n  \\_____|  \\_____|  \\_____|\n"},
                {400,"   _____   _____  \n  / ____| |  __ \\ \n | |      | |  | |\n | |      | |  | |\n | |____  | |__| |\n  \\_____| |_____/ \n"},
                {500,"  _____  \n |  __ \\ \n | |  | |\n | |  | |\n | |__| |\n |_____/ \n"},
                {600, "  _____     _____ \n |  __ \\   / ____|\n | |  | | | |     \n | |  | | | |     \n | |__| | | |____ \n |_____/   \\_____|\n"},
                {700, "  _____     _____    _____ \n |  __ \\   / ____|  / ____|\n | |  | | | |      | |     \n | |  | | | |      | |     \n | |__| | | |____  | |____ \n |_____/   \\_____|  \\_____|\n"},
                {800, "  _____     _____    _____    _____ \n |  __ \\   / ____|  / ____|  / ____|\n | |  | | | |      | |      | |     \n | |  | | | |      | |      | |     \n | |__| | | |____  | |____  | |____ \n |_____/   \\_____|  \\_____|  \\_____|\n"},
                {900, "   _____   __  __ \n  / ____| |  \\/  |\n | |      | \\  / |\n | |      | |\\/| |\n | |____  | |  | |\n  \\_____| |_|  |_|\n"},
                {1000, "  __  __ \n |  \\/  |\n | \\  / |\n | |\\/| |\n | |  | |\n |_|  |_|\n"},
                {0, null},
                {1001, null}
        });
    }

    @Test
    public void testClassIsInstantiable() {  // Controllo superfluo per avere il 100% di code coverage
        try {
            new RomanPrinter();
        }catch (Exception e) {
            fail("La classe RomanPrinter non puo' essere instanziata.");
        }
    }

    @Test
    public void testConvert() {
        try {
            // Esegue la funzione di conversione
            String result = RomanPrinter.print(input);

            // Verifica se la funzione di conversione ha restituito il valore atteso
            assertEquals(expected, result);
        } catch (IllegalArgumentException e) {  // Percorso che dovrebbe eseguire con i parametri 0 e 1001
            if(expected != null) {
                fail("Il programma non funziona correttamente con parametri garantiti. (" + input + ")");
            }
        }
    }
}