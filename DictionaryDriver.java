import java.io.*; // for File
import java.util.*; // for Scanner
public class DictionaryDriver {
    public static void main(String[] args){


        System.out.println("Enter file name: ");
        Scanner scan = new Scanner(System.in);
        String filepath = scan.nextLine();
        System.out.println("Filepath: " + filepath);

        System.out.println("Enter shortest word Length: ");
        int shortest = scan.nextInt();
        System.out.println("Shortest: " + shortest);



        System.out.println("Enter longest word Length: ");
        int longest = scan.nextInt();
        System.out.println("Longest: " + longest);

        Dictionary myWords = new Dictionary();
        ArrayList<String> printDic = myWords.Dictionary(filepath, shortest, longest);
        for(int i=0; i < printDic.size(); i++){
            System.out.println(printDic.get(i));
        }

        File f = new File(filepath);
        if (f.exists() && f.canRead()) {
            System.out.println("The CSV file contains " + f.length() + "words.");
        }else{
            System.out.println("The file does not exist!");
        }
    }
}
