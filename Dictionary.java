import java.io.*; // for File
import java.util.*; // for Scanner



public class Dictionary {


    ///Constructor Method
    public ArrayList<String> Dictionary(String filepath, int shortest, int longest){
        ArrayList<String> words = new ArrayList<String>();
        String wordToken = "";
        try {
            Scanner dataSource = new Scanner(new File(filepath));
            wordToken = dataSource.next();
            //Initialising array with first word, ignoring words not in specified range
            boolean result = false;
            while (result == false) {
                if (wordToken.length() <= shortest) {
                    wordToken = dataSource.next();
                } else if (wordToken.length() > longest) {
                    wordToken = dataSource.next();
                } else {
                    words.add(wordToken.toUpperCase());
                    result = true;
                }
            }
            //
            while(dataSource.hasNext()) {
                wordToken = dataSource.next().toUpperCase();
                String[] parsedWords = wordToken.split(",");


                for(int i = 0; i <= parsedWords.length-1; i++) {
                    int searchIndex = Collections.binarySearch(words, parsedWords[i]);
                    if (searchIndex < 0) {
                        searchIndex = ((searchIndex) * -1) - 1;
                        if (wordToken.length() >= shortest && wordToken.length() <= longest) {
                            words.add(searchIndex, parsedWords[i].trim());
                        }

                    }
                }
            }

        }catch(IOException e) {
            System.out.println("Error!");
        }

        if(words.size() == 0){
            return words;
        }
        return words;
    }
}