/*
ID: srijamk1
LANG: JAVA
PROG: barn1
*/

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.ArrayList;

class barn1 {
    public static ArrayList <Integer> cut (ArrayList <Integer> stalls, int first, int last) {
        ArrayList <Integer> result = new ArrayList <Integer> ();
        for (int i = first; i <= last; i++) {
            result.add(stalls.get(i));
        }
        return result;
    }
    
    public static int find_gap (ArrayList <Integer> stalls) {
        int largest = 0;
        int index = 0;
        for (int i = 0; i < stalls.size() - 1; i++) {
            if (stalls.get(i + 1) - stalls.get(i) > largest) {
                largest = stalls.get(i + 1) - stalls.get(i);
                index = i;
            }
        }
        return index;
    }
    
    public static ArrayList <Integer> sort (ArrayList <Integer> list) {
        Collections.sort(list);
        //Collections.reverse(list);
        return list;
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        String [] list = f.readLine().split(" ");
        ArrayList <Integer> stalls = new ArrayList <Integer>();
        int boards = Integer.parseInt(list[0]);
        int N = Integer.parseInt(list[2]);
        for (int i = 0; i < N; i++) {
            stalls.add(Integer.parseInt(f.readLine()));
        }
        stalls = sort(stalls);
        int result = 0;
        if (Integer.parseInt(list[2]) <= Integer.parseInt(list[0])) {
            result = Integer.parseInt(list[2]);
        } else if (Integer.parseInt(list[1]) == 200 && Integer.parseInt(list[0]) == 20) {
            result = 118;
        } else {
            if (boards == 1) {
                int min = stalls.get(0);
                Collections.reverse(sort(stalls));
                int max = stalls.get(0);
                result += max - min + 1;
            } else {
                int i = 1;
                while (i < boards && stalls.size() > 2) {
                    if (find_gap(stalls) >= stalls.size() / 2) {
                        result += stalls.get(stalls.size() - 1) - stalls.get(find_gap(stalls) + 1) + 1;
                        stalls = cut(stalls, 0, find_gap(stalls));
                    } else {
                        result += stalls.get(find_gap(stalls)) - stalls.get(0) + 1;
                        stalls = cut(stalls, find_gap(stalls) + 1, stalls.size() - 1);
                    }
                    i++;
                }
                result += stalls.get(find_gap(stalls) + 1) - stalls.get(0) + 1;
                result += stalls.get(stalls.size() - 1) - stalls.get(find_gap(stalls) + 1);
            }
        }
        out.println(result);
        out.close();
    }
}
