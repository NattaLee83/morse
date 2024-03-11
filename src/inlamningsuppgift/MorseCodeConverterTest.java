package inlamningsuppgift;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class MorseCodeConverterTest {
    @Test
    public void testMorseCodeToEnglish() {     //namn på min metod.

        MorseCodeConverter converter = new MorseCodeConverter();    // En instans av konverteringsklassen skapas.
        String testdata = ".-";     // Testdatasträng som innehåller morsekoden för bokstaven A skapas.
        String expected = "A";      //  En förväntad utdatavärde "A".

        String actual = converter.getText(testdata);  // Metod getText anropas i converter-objektet med testdatan
        // som parameter för att få ut den faktiska översättningen tillbaka.
        assertEquals(expected, actual); // Det förväntade och det faktiska värdet jämförs, med hjälp av metoden assertEquals
        // för att verifiera att konverteringen är korrekt.
    }

    @Test
    public void testEnglishToMorseCode() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "A";
        String expected = ".-";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testlastZ() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "--..";
        String expected = "Z";
        String actual = converter.getText(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testNumber() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "0";
        String expected = "-----";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testMorseToNumber() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "-----";
        String expected = "0";
        String actual = converter.getText(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testLowerLetter() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "a";
        String expected = ".-";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testSymbol() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "&";
        String expected = "Error! Skriv en alfabet, siffra eller morse.";
        ;
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }


    @Test
    public void testOneWord() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "HELLO";
        String expected = ".... . .-.. .-.. ---";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);

    }

    @Test
    public void testMorseOneWord() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = ".... . .-.. .-.. ---";
        String expected = "H E L L O";
        String actual = converter.getText(testdata);
        assertEquals(expected, actual);

    }


    @Test
    public void testSentence() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "HELLO MOM";
        String expected = ".... . .-.. .-.. ---  -- --- --";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }

    @Test
    public void testLowerAndUpperKeyLetter() {
        MorseCodeConverter converter = new MorseCodeConverter();
        String testdata = "Hello";
        String expected = ".... . .-.. .-.. ---";
        String actual = converter.getMorse(testdata);
        assertEquals(expected, actual);
    }
}
