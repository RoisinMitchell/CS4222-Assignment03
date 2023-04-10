/*
 ============================================================================
 Name        : DictionaryDriver.java
 Author      : Roisin Mitchell
 ID          : 21193762
 Description : A driver class for Dictionary.java class. Testing constructor and methods
 ============================================================================
 */

import java.util.*;
public class DictionaryDriver {
    public static void main(String[] args) {

        //User input for file name
        System.out.println("Enter file name: ");
        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();
        System.out.println("Filepath: " + filepath);

        //User input for shortest word length
        System.out.println("Enter shortest word Length: ");
        int shortest = scan.nextInt();
        System.out.println("Shortest: " + shortest);

        //User input for longest word length
        System.out.println("Enter longest word Length: ");
        int longest = scan.nextInt();
        System.out.println("Longest: " + longest + "\n");

        // Get the list of words from the Dictionary
        Dictionary myWords = new Dictionary(filepath, shortest, longest);
        ArrayList<String> myWordList = myWords.get();
        System.out.println("\n\n------------\nList of Words:");
        for (int i = 0; i < myWordList.size(); i++) {
            System.out.println(myWordList.get(i));
        }


        //***Testing add() Dictionary method***///
        System.out.println("Enter word to add: ");
        String word = scan.next();
        System.out.println("Entering \"" + word + "\" to the list...\n");
        // Add a new word to the Dictionary
        boolean didItAdd = myWords.add(word);
        System.out.println("\nWas the word added? " + word + "\n" + didItAdd);
        // Try adding the same word again
        boolean didItAddAgain = myWords.add(word);
        System.out.println("\nWas the word added again? " + word + "\n" + didItAddAgain);


        //***Testing for word that is too short***//
        System.out.println("Enter a word that is too small: ");
        String tooShortWord = scan.next();
        System.out.println("Attempting to enter \"" + tooShortWord + "\" to the list...\n");
        //adding short word
        boolean didItAddShort = myWords.add(tooShortWord);
        System.out.println("\nWas the short word added? " + tooShortWord + "\n" + didItAddShort);


        //***Testing for word that is too long***//
        System.out.println("Enter a word that is too long: ");
        String tooLongWord = scan.next();
        System.out.println("Attempting to enter \"" + tooShortWord + "\" to the list...\n");
        //adding long word
        boolean didItAddLong = myWords.add(tooLongWord);
        System.out.println("\nWas the long word added?\n" + tooLongWord + "\n" + didItAddLong);


        //***Printing edited word list***//
        ArrayList<String> editedList = myWords.get();
        System.out.println("\n\n------------\nList of Words:");
        for (int i = 0; i < editedList.size(); i++) {
            System.out.println(editedList.get(i));
        }


        //***Testing nextWord() Dictionary method***//
        // Random word from the list
        String next = myWords.nextWord();
        System.out.println("\nCurrent Word: " + next);


        //***Testing inDictionary() Dictionary Method***//
        //User input word to check for in list
        System.out.println("Enter Word To Search: ");
        String searchWord = scan.next();
        System.out.println("Searching for \"" + searchWord + "\" in the list...\n");
        //checking for word in list
        boolean result = myWords.inDictionary(searchWord);
        System.out.println("\nIs the word in the list?\n" + result);
    }
}
