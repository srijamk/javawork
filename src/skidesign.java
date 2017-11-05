/*
ID: srijamk1
LANG: JAVA
PROG: skidesign
*/

import java.io.*;
import java.util.*;
import java.util.Arrays;

class skidesign {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int num = Integer.parseInt(f.readLine());
        int cost = Integer.MAX_VALUE;
        int [] list = new int [num];
        for (int i = 0; i < num; i++) {
            list[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(list);
        int min = 0; 
        int max = 17;
        for (int k = 0; k < 100; k++) {
            int sub_cost = 0;
            for (int j = 0; j < num; j++) {
                if (list[j] < min) {
                    sub_cost += (min - list[j]) * (min - list[j]);
                } else if (list[j] > max) {
                    sub_cost += (list[j] - max) * (list[j] - max);
                }
            }
            if (cost > sub_cost) {
                cost = sub_cost;
            }
            min++;
            max++;
        }
        out.println(cost);
        out.close();
    }
}