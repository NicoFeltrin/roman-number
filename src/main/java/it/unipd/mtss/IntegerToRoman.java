////////////////////////////////////////////////////////////////////
// Felician Mario Necsulescu 2111935
// Niccolò Feltrin 2111947
////////////////////////////////////////////////////////////////////

package it.unipd.mtss;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class IntegerToRoman {
    public static String convert(int number) {
        
        // Controlla che il numero sia compreso tra 1 e 1000        
        if(!(number >= 1 && number <= 1000)) {
            throw new IllegalArgumentException("Errore: il numero deve essere compreso tra 1 e 1000.");
        }

        // LinkedHashMap che associa una lettera ad un numero
        LinkedHashMap<Integer, String> valuesToRoman = new LinkedHashMap<Integer, String>() {{
            put(1000, "M");
            put(900, "CM");
            put(500, "D");
            put(400, "CD");
            put(100, "C");
            put(90, "XC");
            put(50, "L");
            put(40, "XL");
            put(10, "X");
            put(9, "IX");
            put(5, "V");
            put(4, "IV");
            put(1, "I");
        }};

        StringBuilder romanNumber = new StringBuilder();
        Iterator<Integer> iterator = valuesToRoman.keySet().iterator();  // La LinkedHashMap può esere iterata in modo ordinato ascendente
        int value = iterator.next();  // Punta al primo numero corrente nella mappa (procede in modo decrescente)

        // Il ciclo continua finchè il numero è maggiore di 0
        while (number > 0) {
            if(number >= value) {  // Controlla che il numero sia maggiore o uguale al numero corrente puntato dall'iteratore
                number -= value;  // Sottrae al numero dato in input quello puntato dall'iteratore
                romanNumber.append(valuesToRoman.get(value));  // Aggiunge alla stringa finale la lettera corrispondente
            } else {
                value = iterator.next();  // Va al prossimo numero della LinkedHashMap
            }
        }

        return romanNumber.toString();
    }
}