/*
 ============================================================================
 Name        : Dictionary.java
 Author      : Roisin Mitchell
 ID          : 21193762
 Description : A dictionary class with methods to read csv file and add
               words dependent on parameters passed.
 ============================================================================

  I am assuming from the brief that I am loading a dictionary
  that contains words, commas and spaces only, and no special characters or numbers.
 */


import java.io.*;
import java.util.*;

public class Dictionary {
    private final int inputShort;
    private final int inputLong;
    private ArrayList<String> words;
    public Dictionary(String filepath, int shortest, int longest){
        //Initialising arraylist that is returned by this method
        words = new ArrayList<String>();

        inputLong = longest; //to be used in add method
        inputShort = shortest; //to be used in add method

        try {
            //reading data from the given file
            Scanner dataSource = new Scanner(new File(filepath));
            String word;
            String[] parsedWords;

            //looping until all words have been read from the file
            while(dataSource.hasNext()) {
                //Changing each token read in to uppercase
                word = dataSource.next().toUpperCase();
                //splitting the word string to get individual words
                parsedWords = word.split(",");
                //looping over all parsedWords entries
                for(int i = 0; i <= parsedWords.length-1; i++) {
                    //trimming word of any spaces
                    String parsedWord = parsedWords[i].trim();
                    int index = Collections.binarySearch(words, parsedWord);
                    //if the word isn't already in the arraylist
                    if (index < 0) {
                        //binarySearch() returns the location as a negative value offset by +1
                        index = ((index) * -1) - 1;

                        if (parsedWord.length() >= shortest && parsedWord.length() <= longest) {
                            //Adding word to arraylist trimmed of spaces
                                words.add(index, parsedWord);
                        }
                    }
                }
            }
            //handling the exception thrown if file cannot be read
        }catch(IOException e) {
            System.out.println("Cannot Read File!");
            throw new RuntimeException(e);
        }
    }

    public boolean add(String word){
        boolean result = false;
        //getting the uppercase version of the user input and trimming it of spaces
        String userWord = word.toUpperCase().trim();
        int index = Collections.binarySearch(words, userWord);
        //if the word isn't already in the arraylist
        if (index < 0) {
            //binarySearch() returns the location as a negative value offset by +1
            index = ((index) * -1) - 1;
            if (userWord.length() >= inputShort && userWord.length() <= inputLong) {
                //Adding word to arraylist trimmed of spaces
                words.add(index, userWord);
                //setting the result to true to indicate successful addition
                result = true;
            }
        }
        return result;
    }

    //method to get a random word from the dictionary
    public String nextWord(){
        //Generating a random index within the range of the arraylist size
        int index = (int)(Math.random() * words.size());
        return words.get(index);
    }

    public boolean inDictionary(String word){
        boolean wordResult = false;
        String inputWord = word.toUpperCase().trim();
        int index = Collections.binarySearch(words, inputWord);
        if (index >= 0) {
            wordResult = true;
            }
        return wordResult;
    }

    public ArrayList<String> get(){
        return words;
    }
}