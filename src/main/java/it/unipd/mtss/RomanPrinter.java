////////////////////////////////////////////////////////////////////
// Felician Mario Necsulescu 2111935
// Niccolò Feltrin 2111947
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import java.util.HashMap;

public class RomanPrinter {
    public static String print(int num) {
        return printAsciiArt(IntegerToRoman.convert(num));
    }

    private static String printAsciiArt(String romanNumber) {
        StringBuilder asciiArt = new StringBuilder();

        // Ogni elemento delle liste contiene una linea da stampare della lettera corrispondente
        String[] letterI = {" _____ ", "|_   _|", "  | |  ", "  | |  ", " _| |_ ", "|_____|"};
        String[] letterV = {"__      __", "\\ \\    / /", " \\ \\  / / ", "  \\ \\/ /  ", "   \\  /   ", "    \\/    "};
        String[] letterX = {"__   __", "\\ \\ / /", " \\ V / ", "  > <  ", " / . \\ ", "/_/ \\_\\"};
        String[] letterL = {" _      ", "| |     ", "| |     ", "| |     ", "| |____ ", "|______|"};
        String[] letterC = {"  _____ ", " / ____|", "| |     ", "| |     ", "| |____ ", " \\_____|"};
        String[] letterD = {" _____  ", "|  __ \\ ", "| |  | |", "| |  | |", "| |__| |", "|_____/ "};
        String[] letterM = {" __  __ ", "|  \\/  |", "| \\  / |", "| |\\/| |", "| |  | |", "|_|  |_|"};

        // Associa ad ogni carattere la stampa ASCII corrispondente
        HashMap<Character, String[]> letterToASCII = new HashMap<Character, String[]>() {{
            put('I', letterI);
            put('V', letterV);
            put('X', letterX);
            put('L', letterL);
            put('C', letterC);
            put('D', letterD);
            put('M', letterM);
        }};

        for(int i = 0; i < 6; i++) {  // Cicla su tutte le linee (6)
            for(char c : romanNumber.toCharArray()) {  // Cicla su tutti i caratteri del numero romano
                asciiArt.append(" ").append(letterToASCII.get(c)[i]);  // Aggiunge la linea corrispondente del carattere (insieme ad uno spazio)
            }
            asciiArt.append("\n");  // Va a capo dopo aver finito una linea
        }
        return asciiArt.toString();
    }
}