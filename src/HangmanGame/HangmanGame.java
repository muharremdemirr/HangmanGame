package HangmanGame;

import java.util.Scanner;


public class HangmanGame {


    public static void main(String[] args) {

        String line, hiddenWord, guess;
        int chance, numberOfLine, index, controller, a, score, controlIndex, charController, numOfWords;
        boolean runGame, startPlaying, beenGuessed;

        Arrays Arrays = new Arrays();
        String[] words = Arrays.getWords();
        String[] controlArray = Arrays.getControlArray(words.length);
        char[] chars = new char[0];
        Scanner input = new Scanner(System.in);
        runGame = true;
        startPlaying = true;
        controlIndex = 0;
        score = 0;
        System.out.println("Welcome to the hangman game.");
        System.out.println("Please, enter a number to specify number of words you'll see. Max : 2778");
        numOfWords = input.nextInt();
        while (runGame) {
            chance = 6;
            line = "";
            controller = 0;
            hiddenWord = words[(int) (Math.random() * words.length)];

            for (int i = 0; i < controlArray.length; i++) {
                if (controlArray[i].equalsIgnoreCase(hiddenWord)) {
                    startPlaying = false;

                }
                if (!controlArray[i].equalsIgnoreCase(hiddenWord)) {
                    controller++;

                }
                if (controller == controlArray.length) {
                    controlArray[controlIndex] = hiddenWord;
                    controlIndex += 1;
                    startPlaying = true;
                }
            }

            if (startPlaying) {
                chars = Arrays.getCharArray(hiddenWord);
                for (numberOfLine = 0; numberOfLine <= hiddenWord.length() - 1; numberOfLine++) {
                    line += "_";
                }
            }
            System.out.println(line);
            charController = 0;
            while (startPlaying) {

                while (true) {
                    controller = 0;
                    System.out.println("Please, enter your guess. Remember you have only " + chance + " chance.");
                    System.out.println("Also you can quit by writing exit at any time.");

                    guess = input.next();
                    if (guess.equalsIgnoreCase("exit")) {
                        System.out.println("Your score: " + score + " points");
                        System.exit(0);
                    }
                    guess = guess.toUpperCase();
                    beenGuessed = false;

                    for (int i = 0; i < chars.length; i++) {
                        if (chars[i] == guess.charAt(0)) {
                            beenGuessed = true;
                            break;
                        }
                        if (chars[i] != guess.charAt(0)) {
                            controller++;

                        }
                        if (controller == chars.length) {
                            chars[charController] = guess.charAt(0);
                            charController++;
                            beenGuessed = false;
                        }
                    }

                    if (beenGuessed) {
                        System.out.println("Sorry, you tried this letter before.");
                        chance--;
                        charController++;
                        break;
                    } else break;
                }
                if(guess.equalsIgnoreCase(hiddenWord)) {
                    line = hiddenWord;
                }
                else if(!guess.equalsIgnoreCase(hiddenWord)){
                controller = 0;
                for (index = 0; index <= hiddenWord.length() - 1; index++) {
                    a = index + 1;
                    if (guess.charAt(0) == hiddenWord.charAt(index)) {
                        line = line.substring(0, index) + guess.charAt(0) + line.substring(a);
                    } else
                        controller++;
                    if (controller == hiddenWord.length() && !beenGuessed) {
                        chance--;
                        System.out.println("You're mistaken. Try another letter.");
                    }
                }

                System.out.println(line);
                }


                if (chance == 0) {
                    System.out.println("You lost the game. The hidden word was " + hiddenWord + ".");
                    runGame = false;
                    break;

                } else if (line.equals(hiddenWord)) {
                    System.out.println("Congrats, you got it. Hidden word was " + hiddenWord + ".");
                    startPlaying = false;
                    score++;
                    if (score == numOfWords || score == words.length)
                        runGame = false;
                    break;

                }

            }
        }
        System.out.println("Your score is: " + score);
        //score is counting correct answers.
    }

}


