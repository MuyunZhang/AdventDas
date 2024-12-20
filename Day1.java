import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Day1 {
    public static void main(String[] args) {
        int total = 0;
        int score = 0;
        ArrayList<String> fileData = getFileData("src/Day1Input");
        //String[] splitSample = sample.split(" ");
        ArrayList<Integer> leftt = new ArrayList<>();
        ArrayList<Integer> rightt = new ArrayList<>();
        String[] t = fileData.get(0).split("   ");
        for(int i = 0; i < fileData.size(); i ++){
            int len = fileData.size();
            String[] list = fileData.get(i).split("   ");
            int left = Integer.parseInt(list[0]);
            leftt.add(left);
        }
        for(int i = 0; i < fileData.size(); i ++){
            int len = fileData.size();
            String[] list = fileData.get(i).split("   ");
            int right = Integer.parseInt(list[1]);
            rightt.add(right);
        }
        Collections.sort(rightt);
        Collections.sort(leftt);
        for(int i = 0; i < fileData.size(); i ++){
            int left = leftt.get(i);
            int right = rightt.get(i);
            int distance = Math.abs(left - right);
            total += distance;
        }
        System.out.println(total);

        for(int i = 0; i < fileData.size(); i ++){
            int k = leftt.get(i);
            int count = 0;
            for(int j = 0; j < fileData.size(); j ++){
                int hey = rightt.get(j);
                if(k == hey){
                    count ++;
                }
            }
            score += (k * count);
        }
        System.out.println(score);
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