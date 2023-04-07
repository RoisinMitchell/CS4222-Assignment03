/*
 ============================================================================
 Name        : Dictionary.java
 Author      : Roisin Mitchell
 ID          : 21193762
 Description : A dictionary class with methods to read csv file and add
               or remove words dependent on parameters passed.
 ============================================================================

  I am assuming from the brief that I am loading a dictionary
  that contains words, commas and spaces only, and no special characters or numbers.
 */


import java.io.*; // for File
import java.util.*; // for Scanner

public class Dictionary {
    public ArrayList<String> Dictionary(String filepath, int shortest, int longest){
        //Initialising arraylist that is returned by this method
        ArrayList<String> words = new ArrayList<String>();

        try {
            Scanner dataSource = new Scanner(new File(filepath));
            String word = "";
            String[] parsedWords;

            while(dataSource.hasNext()) {
                //Changing each token read in to uppercase
                word = dataSource.next().toUpperCase();
                parsedWords = word.split(",");
                for(int i = 0; i <= parsedWords.length-1; i++) {
                    String parsedWord = parsedWords[i].trim();
                    int index = Collections.binarySearch(words, parsedWord);
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
        }catch(IOException e) {
            System.out.println("Cannot Read File!");
        }
        return words;
    }
}