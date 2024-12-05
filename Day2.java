import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Day2 {
    public static void main(String[] args) {
        int total = 0;
        int fix = 0;
        ArrayList<String> fileData = getFileData("src/Day2Input");
        //String[] splitSample = sample.split(" ");

        ArrayList<String[]> list = new ArrayList();
        for(int i = 0; i < fileData.size(); i ++){
            String[] h = fileData.get(i).split(" ");
            list.add(h);
        }

        for(int i = 0; i < list.size(); i ++){
            int count = 0;
            for(int k = 1; k < list.get(i).length; k ++) {
                int f = Integer.parseInt(list.get(i)[k - 1]);
                int s = Integer.parseInt(list.get(i)[k]);
                if (f < s && s - f > 0 && s - f < 4) {
                    count ++;
                }
            }
            if(count == (list.get(i).length - 1)) {
                total++;
            }
            else if(count == list.get(i).length - 2){
                for(int j = 0; j < list.size(); j ++) {
                    int recount = 0;
                    int position = -1;
                    for (int k = 1; k < list.get(j).length - 1; k++) {
                        int t = Integer.parseInt(list.get(j)[k + 1]);
                        int f = Integer.parseInt(list.get(j)[k - 1]);
                        int s = Integer.parseInt(list.get(j)[k]);
                        if (f < s && s - f > 0 && s - f < 4) {
                            recount++;
                        }
                        else {
                            if(t > s && t - s > 0 && t - s < 4){
                                position = k - 1;
                            }
                            else {
                                position = k;
                            }
                        }
                    }
                    if(position > -1 && recount == count){
                        fix ++;
                    }
                }
            }
        }

        for(int i = 0; i < list.size(); i ++){
            int count = 0;
            for (int k = 1; k < list.get(i).length; k++) {
                int f = Integer.parseInt(list.get(i)[k - 1]);
                int s = Integer.parseInt(list.get(i)[k]);
                if (f > s && f - s > 0 && f - s < 4) {
                    count++;
                }
            }
            if (count == list.get(i).length - 1) {
                total++;
            }
            else if(count == list.get(i).length - 2){
                for(int j = 0; j < list.size(); j ++) {
                    int recount = 0;
                    int position = -1;
                    for (int k = 1; k < list.get(j).length - 1; k++) {
                        int t = Integer.parseInt(list.get(j)[k + 1]);
                        int f = Integer.parseInt(list.get(j)[k - 1]);
                        int s = Integer.parseInt(list.get(j)[k]);
                        if (f > s && f - s > 0 && f - s < 4) {
                            recount++;
                        }
                        else {
                            if(s > t && s - t > 0 && s - t < 4){
                                position = k - 1;
                            }
                            else {
                                position = k;
                            }
                        }
                    }
                    if(position > -1 && recount == count){
                        fix ++;
                    }
                }
            }
        }
        System.out.println(total);
        System.out.println(fix);
        System.out.println(fix + total);
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
        } catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
