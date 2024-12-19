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
        int fuc = 0;
        String direction = "up";
        boolean right = false;
        for(int i = 0; i < fileData.size(); i ++){
            if(fileData.get(i).contains("^")){
                System.out.println(fileData.get(i));
                System.out.println(i);
                dex = fileData.get(i).indexOf("^");
                fuc = i;
            }
            hi.add(fileData.get(i));
        }
        System.out.println(dex);
        boolean hey = true;
        int x = dex;
        int y = fuc;
        while(hey){
            if(direction.equals("right")){
                x ++;
            }
            if(direction.equals("left")){
                x --;
            }
            if(direction.equals("up")){
                y ++;
            }
            if(direction.equals("down")){
                y --;
            }
            x ++;
            if(hi.get(y).substring(x, x + 1).equals("#")){
                direction = direct(direction);
            }

        }



    }
    public static String direct(String k){
        if(k.equals("up")){
            k = "right";
        }
        else if(k.equals("right")){
            k = "down";
        }
        else if(k.equals("down")){
            k = "left";
        }
        else if(k.equals("left")){
            k = "up";
        }
        return k;
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