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
            //Initialising array with first word, checking if it is within correct range
            boolean result = false;
            while (result == false) {
                if (wordToken.length()-1 <= shortest) {
                    wordToken = dataSource.next();
                } else if (wordToken.length()-1 > longest) {
                    wordToken = dataSource.next();
                } else {
                    words.add(wordToken.toUpperCase());
                    result = true;
                }
            }

            while(dataSource.hasNext()) {
                wordToken = dataSource.next();
                int searchIndex = Collections.binarySearch(words, wordToken);
                if(searchIndex < 0){
                    searchIndex = ((searchIndex) * -1) - 1;
                    words.add(searchIndex, wordToken);
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