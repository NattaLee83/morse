package inlamningsuppgift;

import java.util.HashMap;
import java.util.Map;

public class MorseCodeConverter {

    HashMap<String, String> morseToEnglish = new HashMap<>(); // Skapa HashMap för morse till engelska.
    HashMap<String, String> englishToMorse = new HashMap<>(); // Skapa HashMap för engelska till morse.


    public MorseCodeConverter() { //Konstruktorn för MorseCodeConverter-klassen.


        morseToEnglish.put(".-", "A");   //använder metoden put.
        morseToEnglish.put("-...", "B");
        morseToEnglish.put("-.-.", "C");
        morseToEnglish.put("-..", "D");
        morseToEnglish.put(".", "E");
        morseToEnglish.put("..-.", "F");
        morseToEnglish.put("--.", "G");
        morseToEnglish.put("....", "H");
        morseToEnglish.put("..", "I");
        morseToEnglish.put(".---", "J");
        morseToEnglish.put("-.-", "K");
        morseToEnglish.put(".-..", "L");
        morseToEnglish.put("--", "M");
        morseToEnglish.put("-.", "N");
        morseToEnglish.put("---", "O");
        morseToEnglish.put(".--.", "P");
        morseToEnglish.put("--.-", "Q");
        morseToEnglish.put(".-.", "R");
        morseToEnglish.put("...", "S");
        morseToEnglish.put("-", "T");
        morseToEnglish.put("..-", "U");
        morseToEnglish.put("...-", "V");
        morseToEnglish.put(".--", "W");
        morseToEnglish.put("-..-", "X");
        morseToEnglish.put("-.--", "Y");
        morseToEnglish.put("--..", "Z");

        englishToMorse.put("A", ".-");
        englishToMorse.put("B", "-...");
        englishToMorse.put("C", "-.-.");
        englishToMorse.put("D", "-..");
        englishToMorse.put("E", ".");
        englishToMorse.put("F", "..-.");
        englishToMorse.put("G", "--.");
        englishToMorse.put("H", "....");
        englishToMorse.put("I", "..");
        englishToMorse.put("J", ".---");
        englishToMorse.put("K", "-.-");
        englishToMorse.put("L", ".-..");
        englishToMorse.put("M", "--");
        englishToMorse.put("N", "-.");
        englishToMorse.put("O", "---");
        englishToMorse.put("P", ".--.");
        englishToMorse.put("Q", "--.-");
        englishToMorse.put("R", ".-.");
        englishToMorse.put("S", "...");
        englishToMorse.put("T", "-");
        englishToMorse.put("U", "..-");
        englishToMorse.put("V", "...-");
        englishToMorse.put("W", ".--");
        englishToMorse.put("X", "-..-");
        englishToMorse.put("Y", "-.--");
        englishToMorse.put("Z", "--..");

        englishToMorse.put("0", "-----");
        englishToMorse.put("1", ".----");
        englishToMorse.put("2", "..---");
        englishToMorse.put("3", "...--");
        englishToMorse.put("4", "....-");
        englishToMorse.put("5", ".....");
        englishToMorse.put("6", "-....");
        englishToMorse.put("7", "--...");
        englishToMorse.put("8", "---..");
        englishToMorse.put("9", "----.");

        morseToEnglish.put("-----", "0");
        morseToEnglish.put(".----", "1");
        morseToEnglish.put("..---", "2");
        morseToEnglish.put("...--", "3");
        morseToEnglish.put("....-", "4");
        morseToEnglish.put(".....", "5");
        morseToEnglish.put("-....", "6");
        morseToEnglish.put("--...", "7");
        morseToEnglish.put("---..", "8");
        morseToEnglish.put("----.", "9");
    }

    public String getText(String testdata) {    // Tar in en sträng av morsekod och konverterar den till engelsk text.

        if (testdata.isBlank()) { // Kontrollerar om inmatningen är tom.
            return "Error! Skriv en alfabet, siffra eller morse."; // Om en morsekod inte finns i HashMap skickas ett felmeddelande tillbaka.
        }
        StringBuilder result = new StringBuilder(); // Skapar en StringBuilder för att lagra resultatet.

        String[] morsearray = testdata.split("\\s"); // Delar upp morsekoden baserat på mellanslag och skapar en array av strängar, morsearray.
        for (int i = 0; i < morsearray.length; i++) {   //Loopar igenom varje element i morsearrayn.

            String morsecharacter = morsearray[i]; // Hämtar en morsekod från  morsearray och lagrar det i en variabeln, morsecharacter.

            String morseCode = morseToEnglish.get(morsecharacter); // Hämtar den eng. bokstaven för den morsekoden från hashmapen morseToEnglish
                                                                    // och lagrar det i variabeln morseCode.
            if (morseCode == null) { //Om morseToEnglish inte finns (det vill säga, morseCode är null.
                                        // returneras ett felmeddelande.

                return "Error! Skriv en alfabet, siffra eller motsvarande morsekod.";
            }
            result.append(morseCode).append(" "); // Lägger till den engelska bokstaven i resultatet
                                                    // och lägger även till ett mellanslag efter varje tecken.
        }
        return result.toString().trim(); //Returnerar den kompletta morsekoden som en sträng efter att eventuella överflödiga
                                            // mellanslag har trimmats bort från början och slutet av strängen.

    }

    public String getNumber(String morseNumber) { //Metod för att få nummer från morsekod.
        for (Map.Entry<String, String> entry : morseToEnglish.entrySet()) { //Loopar igenom alla element i en Map (morseToEnglish).
            // För varje element i loopen, hämtas nyckeln (key) och värdet (value) och de lagras i en variabel, entry.

            if (entry.getValue().equals(morseNumber)) { // Om värdet (value) som finns kopplat till nyckeln (key) i inmatningen (entry)
                                                        //är lika med morsekoden (morseNumber).
                return entry.getKey(); //Returnerar den motsvarande nyckeln (numret).
            }
        }
        return null; //Om ingen matchning hittas, returneras null.
    }

    public String getMorse(String testdata) { //Metod för att konvertera text till morsekod.
        StringBuilder result = new StringBuilder(); // Skapar en StringBuilder-objekt för att lagra resultatet.

        for (int i = 0; i < testdata.length(); i++) { // Loopar igenom varje tecken i texten.
            char character = testdata.charAt(i);    // I varje steg av loopen hämtar koden en bokstav från testdata på positionen i och
                                                    // lagrar den i variabeln character.
            if (Character.isWhitespace(character)) { // kontrollerar om karaktären är ett mellanslag.
                result.append(" "); // Om det är ett mellanslag, läggs ett mellanslag till i result-strängen.

            } else { // Om inte, körs koden inuti den här else-blocket.
                String charString = String.valueOf(character).toUpperCase(); // konverteras till en stor bokstav och sparas i variabeln charString.
                String morseCode = englishToMorse.get(charString); // Tar en bokstav och letar upp/matchas dess motsvarande morsekod i listan englishToMorse.
                                                                    // Sedan sparas morsekoden i variabeln morseCode.
                if (morseCode == null) {    //Kontrollerar om morsebokstaven inte finns i HashMap.
                    return "Error! Skriv en alfabet, siffra eller morse."; // Om det inte finns någon morsekod för den angivna bokstaven,
                                                                             // returneras felmeddelandet.

                }
                result.append(morseCode).append(" "); //Om det finns en morsekod för den aktuella bokstaven,
                                                     //läggs morsekoden till i result-strängen, följt av ett mellanslag.
            }
        }
        return result.toString().trim(); // Returnerar den kompletta morsekoden efter att eventuella överflödiga mellanslag har trimmats bort
                                        // från början och slutet av strängen.
    }

    public boolean didWeStop(String userInput) { // Kontrollera om användaren har skrivit "stopp".
        return userInput.equalsIgnoreCase("stopp"); //Returnerar sant om användaren har skrivit "stopp".
    }
}





