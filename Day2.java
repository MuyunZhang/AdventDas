import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class Day2 {
    public static void main(String[] args) {
        int total = 0;
        int fix = 0;
        ArrayList<String> fileData = getFileData("src/Day2Input");
        //String[] splitSample = sample.split(" ");

        ArrayList<String[]> list = new ArrayList();
        ArrayList<String[]> rlist = new ArrayList();
        for (int i = 0; i < fileData.size(); i++) {
            String[] h = fileData.get(i).split(" ");
            list.add(h);
        }
        for (int i = 0; i < fileData.size(); i++) {
            String[] h = fileData.get(i).split(" ");
            rlist.add(h);
        }

        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            int position = -1;
            int times = 0;
            for (int k = 1; k < list.get(i).length; k++) {
                int f = Integer.parseInt(list.get(i)[k - 1]);
                int s = Integer.parseInt(list.get(i)[k]);
                if (f < s && s - f > 0 && s - f < 4) {
                    count++;
                }
            }
            if (count == (list.get(i).length - 1)) {
                total++;
            }
            else {
                int recount = 0;
                for (int k = 1; k < list.get(i).length - 1; k++) {
                    int t = Integer.parseInt(list.get(i)[k + 1]);
                    int f = Integer.parseInt(list.get(i)[k - 1]);
                    int s = Integer.parseInt(list.get(i)[k]);
                    if (f < s && s - f > 0 && s - f < 4) {
                        recount++;
                    } else {
                        if (t > s && t - s > 0 && t - s < 4) {
                            position = k - 1;
                            times++;
                            recount++;
                        }
                        else {
                            position = k;
                            times++;
                            recount++;
                        }
                    }
                }
                int len = list.get(i).length;
                int se = Integer.parseInt(list.get(i)[len - 1]);
                int ss = list.get(i).length - 1;
                int fi = Integer.parseInt(list.get(i)[len - 2]);
                if (fi < se && se - fi > 0 && se - fi < 4) {
                    recount++;
                }
                else {
                    times ++;
                    position = ss;
                }
                if (position > -1 && times == 1) {
                    boolean con = true;
                    for (int k = 1; k < list.get(i).length; k++) {
                        if (position == 0) {
                            int f = Integer.parseInt(list.get(i)[1]);
                            int s = Integer.parseInt(list.get(i)[2]);
                            if (f < s && s - f > 0 && s - f < 4) {

                            } else {
                                con = false;
                            }
                        }
                        if (position != k && position != k - 1) {
                            int f = Integer.parseInt(list.get(i)[k - 1]);
                            int s = Integer.parseInt(list.get(i)[k]);
                            if (f < s && s - f > 0 && s - f < 4) {

                            } else {
                                con = false;
                            }
                        }
                        else if(position == k - 1 && k > 1){
                            int right = k;
                            int left = k - 2;
                            int f = Integer.parseInt(list.get(i)[left]);
                            int s = Integer.parseInt(list.get(i)[right]);
                            if (f < s && s - f > 0 && s - f < 4) {

                            } else {
                                con = false;
                            }
                        }
                        else if (k == position && k < list.get(i).length - 1) {
                            int right = k + 1;
                            int left = k - 1;
                            int f = Integer.parseInt(list.get(i)[left]);
                            int s = Integer.parseInt(list.get(i)[right]);
                            if (f < s && s - f > 0 && s - f < 4) {

                            } else {
                                con = false;
                            }
                        }
                        else if (k == position){
                            int right = k - 1;
                            int left = k - 2;
                            int f = Integer.parseInt(list.get(i)[left]);
                            int s = Integer.parseInt(list.get(i)[right]);
                            if (f < s && s - f > 0 && s - f < 4) {

                            } else {
                                con = false;
                            }
                        }
                    }
                    if (con) {
                        fix++;
                    }
                }
            }
        }
        //2nd

        for (int i = 0; i < list.size(); i++) {
            int position = -1;
            int times = 0;
            int count = 0;
            for (int k = 1; k < list.get(i).length; k++) {
                int f = Integer.parseInt(list.get(i)[k - 1]);
                int s = Integer.parseInt(list.get(i)[k]);
                if (f > s && f - s > 0 && f - s < 4) {
                    count++;
                }
            }
            if (count == (list.get(i).length - 1)) {
                total++;
            } else {
                for (int k = 1; k < list.get(i).length - 1; k++) {
                    int t = Integer.parseInt(list.get(i)[k + 1]);
                    int f = Integer.parseInt(list.get(i)[k - 1]);
                    int s = Integer.parseInt(list.get(i)[k]);
                    if (f > s && f - s > 0 && f - s < 4) {

                    } else {
                        if (s > t && s - t > 0 && s - t < 4) {
                            position = k - 1;
                            times++;
                        } else {
                            position = k;
                            times++;
                        }
                    }
                }
                int len = list.get(i).length;
                int se = Integer.parseInt(list.get(i)[len - 1]);
                int ss = list.get(i).length - 1;
                int fi = Integer.parseInt(list.get(i)[len - 2]);
                if (se < fi && fi - se > 0 && fi - se < 4) {

                }
                else {
                    times ++;
                    position = ss;
                }
                if (position > -1 && times == 1) {
                    boolean con = true;
                    for (int k = 1; k < list.get(i).length; k++) {
                        if (position == 0) {
                            int f = Integer.parseInt(list.get(i)[1]);
                            int s = Integer.parseInt(list.get(i)[2]);
                            if (f > s && f - s > 0 && f - s < 4) {

                            } else {
                                con = false;
                            }
                        }
                        if (position != k && position != k - 1 && k < list.get(i).length) {
                            int f = Integer.parseInt(list.get(i)[k - 1]);
                            int s = Integer.parseInt(list.get(i)[k]);
                            if (f > s && f - s > 0 && f - s < 4) {

                            } else {
                                con = false;
                            }
                        }
                        else if(position == k - 1 && k > 1){
                            int right = k;
                            int left = k - 2;
                            int f = Integer.parseInt(list.get(i)[left]);
                            int s = Integer.parseInt(list.get(i)[right]);
                            if (f > s && f - s > 0 && f - s < 4) {

                            } else {
                                con = false;
                            }
                        }
                        else if (k == position && k < list.get(i).length - 1) {
                            int right = k + 1;
                            int left = k - 1;
                            int f = Integer.parseInt(list.get(i)[left]);
                            int s = Integer.parseInt(list.get(i)[right]);
                            if (f > s && f - s > 0 && f - s < 4) {

                            } else {
                                con = false;
                            }
                        }
                        else if (k == position){
                            int right = k - 1;
                            int left = k - 2;
                            int f = Integer.parseInt(list.get(i)[left]);
                            int s = Integer.parseInt(list.get(i)[right]);
                            if (f > s && f - s > 0 && f - s < 4) {

                            } else {
                                con = false;
                            }
                        }
                        if (con) {
                            fix++;
                        }
                    }
                }
            }
        }
        System.out.println(total);
        System.out.println(fix);
        System.out.println(fix + total);
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