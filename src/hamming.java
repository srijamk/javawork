/*
 ID: srijamk1
 LANG: JAVA
 PROG: hamming
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

public class hamming {
    
    public static boolean is_valid (String start, String end, int D) {
        int counter = 0;
        for (int i = 0; i < start.length(); i++) {
            if (end.charAt(i) != start.charAt(i)) {
                counter++;
            }
        }
        return counter >= D;
    }
    
    public static String pad_zeroes (String binary, int B) {
        if (binary.length() == B) {
            return binary;
        } else {
            return pad_zeroes("0" + binary, B);
        }
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        String[] input_list = f.readLine().split(" ");
        int N = Integer.parseInt(input_list[0]);
        int B = Integer.parseInt(input_list[1]);
        int D = Integer.parseInt(input_list[2]);
        ArrayList <Integer> result = new ArrayList <Integer>();
        result.add(0);
        int start = 0;
        int level = start;
        int counter = 0;
        //out.println(counter);
        int inc = 1;
        while (counter < N - 1) {
            boolean add = true;
            for (int r: result) {
                if (!is_valid(pad_zeroes(Integer.toBinaryString(level), B), pad_zeroes(Integer.toBinaryString(r), B), D)) {
                    add = false;
                    level++;
                    break;
                }
            }
            if (add) {
                //out.println(level);
                result.add(level);
                counter++;
                if (counter > N) {
                    break;
                }
            }
            
            
        }
        int c = 1;
        for (int i = 0; i < result.size(); i++) {
            if (c != 10 && i != result.size() - 1) {
                out.print(result.get(i) + " ");
                c++;
            } else {
                
                out.print(result.get(i) + "\n");
                c = 1;
            }
            
        }
        out.close();
    }
}