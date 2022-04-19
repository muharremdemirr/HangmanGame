package HangmanGame;

import java.io.*;
import java.util.*;

public class Arrays {

    public static String[] getWords() {
        ArrayList _words = new ArrayList<>();

        BufferedReader file = null;
        try {
            file = new BufferedReader(new FileReader("Words.txt"));
            while (true) {
                String data = file.readLine();
                if (data == null) {
                    break;
                }
                _words.add(data);
            }

            file.close();

        } catch (Exception e) {
            System.out.println("The file not found. Please, verify the game files.");
        }
        String[] words = new String[_words.size()];
        for (int i = 0; i < _words.size(); i++) {
            words[i] = (String) _words.get(i);
        }
        return words;
    }

    public static String[] getControlArray(int length) {
        String[] controlArray = new String[length];
        for (int i = 0; i < length; i++)
            controlArray[i] = "#";

        return controlArray;
    }

    public static char[] getCharArray(String hiddenWord) {
        char[] chars = new char[hiddenWord.length() + 6];
        for (int i = 0; i < hiddenWord.length() + 6; i++) {
            chars[i] = '#';
        }
        return chars;
    }
}
