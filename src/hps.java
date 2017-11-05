import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Collections;

class hps {

    public static int most_freq (ArrayList <String> n_list, int lo, int hi) {
        ArrayList <String> list = new ArrayList <String>(n_list.subList(lo, hi));
        int h = Collections.frequency(list, "H");
        int s = Collections.frequency(list, "S");
        int p = Collections.frequency(list, "P");
        return Math.max(p, Math.max(h, s));
    }
    
    public static int trial (ArrayList <String> list) {
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            int score = most_freq(list, 0, i);
            if (score > max) {
                //System.out.println(i);
                max = score;
            }
        }
        return max;
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));  
        int games = Integer.parseInt(f.readLine());
        ArrayList <String> list = new ArrayList <String> ();
        for (int i = 0; i < games; i++) {
            list.add(f.readLine());
        }
        out.println(trial(list));
        out.close();
    }
}