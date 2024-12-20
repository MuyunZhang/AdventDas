import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int total = 0;
        int wrong = 0;
        int fix = 0;
        int fix2 = 0;
        ArrayList<String> fileData = getFileData("src/Day2Input");
        //String[] splitSample = sample.split(" ");

        ArrayList<String[]> list = new ArrayList();
        ArrayList<Integer> ist = new ArrayList();
        ArrayList<Integer> llist = new ArrayList();
        ArrayList<Integer> rlist = new ArrayList();
        ArrayList<ArrayList> w = new ArrayList();
        ArrayList<ArrayList> q = new ArrayList();
        for (int i = 0; i < fileData.size(); i++) {
            String[] h = fileData.get(i).split(" ");
            list.add(h);
        }
        for (int i = 0; i < fileData.size(); i++) {
            String[] h = fileData.get(i).split(" ");
            ArrayList<Integer> hi = new ArrayList<>();
            for(int s = 0; s < h.length; s++){
                hi.add(Integer.parseInt(h[s]));
            }
            w.add(hi);
        }
        for (int i = 0; i < fileData.size(); i++) {
            String[] h = fileData.get(i).split(" ");
            ArrayList<Integer> hi = new ArrayList<>();
            for(int s = 0; s < h.length; s++){
                hi.add(Integer.parseInt(h[s]));
            }
            q.add(hi);
        }

        for (int i = 0; i < fileData.size(); i++) {
            String[] h = fileData.get(i).split(" ");
            rlist.add(1);
        }
        for (int i = 0; i < fileData.size(); i++) {
            String[] h = fileData.get(i).split(" ");
            llist.add(1);
        }
        System.out.println(w.get(999).get(5));
        System.out.println(w.get(4));

        for (int i = 0; i < list.size(); i++) {
            boolean count = true;
            int sub = 0;
            int position = -1;
            int times = 0;
            for (int k = 1; k < list.get(i).length; k++) {
                int f = Integer.parseInt(list.get(i)[k - 1]);
                int s = Integer.parseInt(list.get(i)[k]);
                if (f < s && s - f > 0 && s - f < 4) {

                }
                else {
                    count = false;
                }
            }
            if (count) {
                total++;
            }
            else {
                //10 11 12 19 13
                for (int k = 1; k < list.get(i).length - 1; k++) {
                    int f = Integer.parseInt(list.get(i)[k - 1]);
                    int s = Integer.parseInt(list.get(i)[k]);
                    int t = Integer.parseInt(list.get(i)[k + 1]);
                    if (f < s && s - f > 0 && s - f < 4) {
                    }
                    else {
                        times ++;
                        if (t > s && t - s > 0 && t - s < 4) {
                            position = k - 1;
                        }
                        else {
                            position = k;
                        }
                    }
                    if(k == list.get(i).length - 2){
                        if(s < t && t - s > 0 && t - s < 4){

                        }
                        else if(f < s && s - f > 0 && s - f < 4 && f < t && t - s > 0 && t - f < 4){
                            position = k;
                            times ++;
                        }
                        else{
                            position = k + 1;
                            times ++;
                        }
                    }
                }
                if(position >= -1 && times == 1){
                    w.get(i).remove(position);
                    ist.add(1);
                    llist.set(i,4);
                }
            }
        }
        //2nd

        for (int i = 0; i < list.size(); i++) {
            int position = -1;
            int times = 0;
            int sub = i;
            boolean count = true;
            for (int k = 1; k < list.get(i).length; k++) {
                int f = Integer.parseInt(list.get(i)[k - 1]);
                int s = Integer.parseInt(list.get(i)[k]);
                if (f > s && f - s > 0 && f - s < 4) {

                }
                else {
                    count = false;
                }
            }
            if (count) {
                total++;
            }
            else if(llist.get(i) < 4){
                for (int k = 1; k < list.get(i).length - 1; k++) {
                    int t = Integer.parseInt(list.get(i)[k + 1]);
                    int f = Integer.parseInt(list.get(i)[k - 1]);
                    int s = Integer.parseInt(list.get(i)[k]);
                    if (f > s && f - s > 0 && f - s < 4) {

                    }
                    else {
                        times ++;
                        if (s > t && s - t > 0 && s - t < 4) {
                            position = k - 1;
                        } else {
                            position = k;
                        }
                    }
                    if(k == list.get(i).length - 2 && times<=1){
                        if(s > t && s - t > 0 && s - t < 4){

                        }
                        else if(f > s && f - s > 0 && f - s < 4 && f > t && f - t > 0 && f - t < 4){
                            times ++;
                            position = k;
                        }
                        else{
                            times ++;
                            position = k + 1;
                        }
                    }
                }
                if (position > -1 && times ==1) {
                    ist.add(1);
                    w.get(i).remove(position);
                }
            }
        }
        for(int i = 0; i < w.size(); i ++){
            boolean count = true;
            for (int k = 1; k < w.get(i).size(); k++) {
                int f = (int) w.get(i).get(k - 1);
                int s = (int) w.get(i).get(k);
                if (f < s && s - f > 0 && s - f < 4) {

                }
                else {
                    count = false;
                }
            }
            if (count) {
                fix2++;
            }
        }
        for(int i = 0; i < w.size(); i ++){
            boolean count = true;
            for (int k = 1; k < w.get(i).size(); k++) {
                int f = (int) w.get(i).get(k - 1);
                int s = (int) w.get(i).get(k);
                if (f > s && f - s > 0 && f - s < 4) {

                }
                else {
                    count = false;
                }
            }
            if (count) {
                fix2++;
            }
        }
        System.out.println(total);
        System.out.println(ist.size());
        System.out.println(fix + total);
        System.out.println(fix2);
    }


    public static ArrayList<String> getFileData (String fileName){
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