import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Day6 {
    public static void main(String[] args) {
        int total = 0;
        int score = 0;
        ArrayList<String> fileData = getFileData("src/Day6Input");
        //String[] splitSample = sample.split(" ");
        ArrayList<Integer> leftt = new ArrayList<>();
        ArrayList<Integer> rightt = new ArrayList<>();
        ArrayList<String> hi = new ArrayList<>();
        int dex = 0;
        for(int i = 0; i < fileData.size(); i ++){
            if(fileData.get(i).contains("^")){
                System.out.println(fileData.get(i));
                System.out.println(i);
                dex = fileData.get(i).indexOf("^");
            }
            hi.add(fileData.get(i));
        }
        System.out.println(dex);





    }


    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}