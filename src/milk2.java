/*
ID: srijamk1
LANG: JAVA
PROG: milk2
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
class milk2 {
    public static boolean overlap (int[] first, int[] second, int index, int next_index) {
        if (first[index] < first[next_index] && (second[next_index] > second[index] && second[index] >= first[next_index]) || (second[index] > second[next_index])) {
            return true;
        }
        return false;
    }
    public static boolean is_inside (int[] first, int [] second, int index, int next_index) {
        return first[index] <= first[next_index] && second[index] >= second[next_index];
    }
    public static int min (int[] list) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] < min) {
                min = list[i];
                result = i;
            }
        }
        return result;
    }
    public static int max (int[] list) {
        int max = 0;
        int result = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
                result = i;
            }
        }
        return result;
    }

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        int farmers = Integer.parseInt(f.readLine());
        int [] first_ranges = new int [farmers];
        int [] second_ranges = new int [farmers];
        int longest_milking = 0;
        int longest_idle = 0;
        for (int i = 0; i < farmers; i++) {
            String [] line = f.readLine().split(" ");
            first_ranges[i] = Integer.parseInt(line[0]);
            second_ranges[i] = Integer.parseInt(line[1]);        
        }
        
        if (first_ranges.length == 1) {
            out.println((second_ranges[0] - first_ranges[0]) + " " + 0);
        } else {
            int minimum = min(first_ranges);
            int maximum = max(second_ranges);
            int long_milking = 0;
            int long_idle = 0;
            
            for (int i = first_ranges[minimum]; i <= second_ranges[maximum]; i++) {
                boolean should_add = false;
                for (int in = 0; in < farmers; in++) {
                    if (i == 1 || i == 0 || (first_ranges[in] <= i && i <= second_ranges[in] && first_ranges[in] <= i - 0.5 && i - 0.5 <= second_ranges[in])) {
                        should_add = true;
                        
                    }
                }
                if (should_add) {
                    //System.out.println(i + ": " + long_milking);
                    if (i == second_ranges[maximum]) {
                        
                        if (long_milking >= longest_milking) {
                            longest_milking = long_milking;
                            break;
                        }                    
                    }
                    if (long_idle > longest_idle) {
                        longest_idle = long_idle;
                    }
                    long_milking++;
                    long_idle = 0;
                    
                } else {
                    if (long_milking > longest_milking) {
                        longest_milking = long_milking;
                        
                    }
                    
                    long_idle++;
                    long_milking = 0;
                    
                }
            } 
            out.println(longest_milking + " " + longest_idle);
        }

        
        out.close();
    }
}