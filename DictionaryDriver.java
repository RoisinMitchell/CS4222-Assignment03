/*
 ============================================================================
 Name        : DictionaryDriver.java
 Author      : Roisin Mitchell
 ID          : 21193762
 Description : Testing Dictionary class methods
 ============================================================================
 */

import java.util.*;
public class DictionaryDriver {
    public static void main(String[] args) {

        /*I am assuming the testing is being conducted on a csv file
          where I am aware of the words it contains.
        */

        //Initialising variables with words to add to the list that are not in csv file
        String[] addWordsArr = {"zebra","holy","cheese","pop","saint","pool","red"};
        String addWord= addWordsArr[(int) (Math.random() * (addWordsArr.length))].toUpperCase();


        //Initialising variables with words that are in the csv file
        String[] correctWordArr = {"waiting","disease","name","bread","violent","plough","sea","tree","knee","finger"};
        String correctWord = correctWordArr[(int) (Math.random() * (correctWordArr.length))].toUpperCase();
        String correctSearch = correctWordArr[(int) (Math.random() * (correctWordArr.length))].toUpperCase();

        //Initialising variables with words that are not in the csv file
        String[] wrongWordArr = {"aaa", "bbb", "ccc", "ddd", "eee"};
        String wrongSearch = wrongWordArr[(int) (Math.random() * (wrongWordArr.length))].toUpperCase();

        //Initialising variables with words that are too big for the program
        String[] wrongWordLengthArr = {"abcdefghijklmnopqrstuvwxyz", "qwertyuiopasdfghjkllzxcv", "ibjnackjacsibkjbcaskjb"};
        String wrongWordLength = wrongWordLengthArr[(int) (Math.random() * (wrongWordLengthArr.length))].toUpperCase();


        if(args.length == 3){
            String filepath = args[0];
            int shortest = Integer.parseInt(args[1]);
            int longest = Integer.parseInt(args[2]);

            Dictionary myWords = new Dictionary(filepath, shortest, longest);

            //Printing list of words
            ArrayList<String> myWordList = myWords.get();
            System.out.println("List of Words:");
            for (String s : myWordList) {
                System.out.println(s);
            }

            //***Testing add() Dictionary method***///

            //Adding new words to the list
            System.out.println("\n1. Adding \"" + addWord + "\" to the list...");
            // Adding a new word to the Dictionary
            boolean didItAdd = myWords.add(addWord);
            if(didItAdd){
                System.out.println("---The word \"" + addWord+ "\" was added.");
            }else{
                if(addWord.length() >= args[1].length() && addWord.length() <= args[2].length()){
                    System.out.println("---The word is already in the list!");
                }else{
                    System.out.println("---The word length is wrong!");
                }
            }


            //Trying to add word that is already in the list
            System.out.println("\n2. Attempting to add \"" + correctWord + "\" to the list...");
            // Adding a new word to the Dictionary
            boolean didItAddCorrect = myWords.add(correctWord); //User input for word
            if(didItAddCorrect){
                System.out.println("---The word \"" + correctWord + "\" was added.");
            }else{
                System.out.println("The word was not added!");
            }

            //Trying to add a word that is too long for the list
            System.out.println("\n3. Attempting to add \"" + wrongWordLength + "\" to the list...");
            // Adding a new word to the Dictionary
            boolean didItAddFalse = myWords.add(wrongWordLength); //User input for word
            if(didItAddFalse){
                System.out.println("---The word \"" + wrongWordLength + "\" was added. It should not have been.");
            }else{
                System.out.println("---The word is too long for the list!");
            }

            //***Testing nextWord() Dictionary method***//
            //Random word from the list
            String next = myWords.nextWord();
            System.out.println("\nThe next word in the list is \""  + next + "\"\n");

            //***Testing inDictionary() Dictionary Method***//
            //Testing on correct words
            System.out.println("\nSearching for \"" + correctSearch + "\" in the list...");
            //checking for word in list
            boolean correctResult = myWords.inDictionary(correctSearch);
            if(correctResult){
                System.out.println("---The word was found!\n");
            }else{
                System.out.println("---The word was not found!\n");
            }

            //Testing on wrong words
            System.out.println("\n4. Searching for \"" + wrongSearch + "\" in the list...");
            //checking for word in list
            boolean wrongResult = myWords.inDictionary(wrongSearch);
            if(wrongResult){
                System.out.println("---The word was found! It should not have been\n");
            }else{
                System.out.println("---The word was not found!\n");
            }

        }else{
            System.out.println("Please provide three command line arguments!");
            System.exit(0);
        }

    }
}
