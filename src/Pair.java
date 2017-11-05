import java.io.*;
import java.util.*;
import java.util.Collections;
import java.lang.Math;
class Pair {
    public static ArrayList <Integer> shift (ArrayList <Integer> times) {
        
        int newl = times.get(0);
        times.remove(0);
        times.add(newl);
        return times;
    }
    
    public static int logify (ArrayList <Integer> times, int result, int first, int last) {
        if (first == last - 1) {
            return result;
        }
        
        if ((times.get(first) + times.get(last)) > result) {
            return logify(times, Integer.MAX_VALUE, first + 1, times.size() - 1);
        } else {
            return logify(times, (times.get(first) + times.get(last)), first + 1, last - 1);
        }
    }
    
    public static void main (String [] args) throws java.lang.Exception {
        BufferedReader f = new BufferedReader(new FileReader("pairup.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList <Integer> times = new ArrayList <Integer>();
        int min = Integer.MAX_VALUE;
        int second_min = min;
        int max = 0;
        int second_max = max;
        for (int i = 0; i < N; i++) {
            String [] line = f.readLine().split(" ");
            /*
             for (int j = 0; j < Integer.parseInt(line[0]); j++) {
             times.add(Integer.parseInt(line[1]));
             }
             */
            if (Integer.parseInt(line[1]) < min) {
                min = Integer.parseInt(line[1]);
            }
            if (Integer.parseInt(line[1]) > min && Integer.parseInt(line[1]) < second_min) {
                second_min = Integer.parseInt(line[1]);
            }
            if (Integer.parseInt(line[1]) > max) {
                max = Integer.parseInt(line[1]);
            }
            if (Integer.parseInt(line[1]) < max && Integer.parseInt(line[1]) > second_max) {
                second_max = Integer.parseInt(line[1]);
            }
        }
        out.println(Math.max(min + max, second_min + second_max));
        out.close();
    }
}