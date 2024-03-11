package inlamningsuppgift;

import java.util.Scanner;

public class Morse {
    public static void main(String[] args) {
        MorseCodeConverter converter = new MorseCodeConverter(); // Skapar en instans av MorseCodeConverter-klassen.

        String userinput; // Deklarerar en variabel för användarindata.
        Scanner scan = new Scanner(System.in); // Läsa indata från användaren.


        while (true) { // Oändlig loop som fortsätter tills programmets körning avbryts.
            System.out.println("Vad vill du översätta?");
            userinput = scan.nextLine(); // Läser in användarens input och tilldelar den till variabeln userinput.

            String text = userinput.toUpperCase(); // Konverterar användarens input till stora bokstäver.
            String resultat = converter.getMorse(text); // Anropar getMorse-metoden för att konvertera texten till morsekod.
                            //Använder MorseCodeConverter-objektet för att konvertera användarens input till morsekod och sparar resultatet i variabeln resultat.

            if (resultat == null) { // Kontrollerar om resultatet är null.
                System.out.println("Avsluta programmet, skriv: stopp");
                continue; // Fortsätter loopen om resultatet är null.
            }
            String resultatText = converter.getText(text); // Konverterar användarens input till text och sparar resultatet i variabeln resultatText.

            //Kontrollerar om användarens input innehåller giltiga morsekod-tecken.
            if (text.matches("^[.\\-\\s]+$")) { // innehåller tecken som antingen är punkter(.), bindestreck(-), mellanslag(\s).
                System.out.println("Den konverterade texten är:" + resultatText);
            } else { //Om inmatningen inte är morsekod.
                System.out.println("Den konverterade texten är:" + resultat);

            }


            System.out.println("Avsluta programmet, skriv: stopp");
            if (converter.didWeStop(userinput)) { // Kontrollerar om användaren skrivit stopp.
                break; // Bryter ur loopen om användaren har angivit att programmet ska avslutas.
            }

        }

    }
}