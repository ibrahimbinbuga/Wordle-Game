import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Wordle {
    public static void main(String[] args) throws IOException {

        String[] wordList = new String[2317];

        //to read the file
        FileReader fileReader = new FileReader("dict.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        //to send words to array
        for (int i = 0; i < 2317; i++) {
            wordList[i] = bufferedReader.readLine();
        }

        //random keyword
        Random keyWord = new Random();
        int randomNumber = keyWord.nextInt(wordList.length);

        //a string array to check the letters
        String key = wordList[randomNumber];

        char[] keyWordLetters = key.toCharArray();


        //six words for command line arguements
        String word1 = args[0], word2 = args[1], word3 = args[2], word4 = args[3], word5 = args[4], word6 = args[5];


        //to check letters
        for (int i = 0; i < 6; i++) {
            System.out.println("Try" + (i + 1) + " (" + args[i] + "):");
            if (args[i].length() != 5) {
                System.out.println("The length of word must be five!");
            }
            if (args[i].length() == 5) {
                if (Arrays.asList(wordList).contains(args[i])) {
                    if (args[i].equals(key)) {
                        System.out.println("Congratulations! You guess right in" + (i + 1) + "shot!");
                        break;
                    } else {
                        for (int f = 0; f < 5; f++) {
                            if (args[i].charAt(f) == keyWordLetters[f]) {
                                System.out.println((f + 1) + ". letter exists and located right position.");
                            } else {
                                if (key.contains(String.valueOf(args[i].charAt(f)))) {
                                    System.out.println((f + 1) + ". letter exists but located wrong position.");
                                } else {
                                    System.out.println((f + 1) + ". letter does not exists.");
                                }
                            }
                        }
                    }

                } else {
                    System.out.println("The word does not exist in the dictionary!");
                }
            }
            if (i == 5 && !args[i].equals(key)) {
                System.out.println("You exceeded maximum try shot!");
                System.out.println("You failed! The key word is " + key + ".");
            }
        }
    }
}