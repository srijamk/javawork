/*
 ID: srijamk1
 LANG: JAVA
 PROG: money
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;


class money {
    private static ArrayList <String[]> magic = new ArrayList <String[]>();
    public static void main (String [] args) throws IOException {
        Scanner scan = new Scanner(new File("money.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
        int num_coins = scan.nextInt(); // 3
        num_coins = 0;
        int total = scan.nextInt();
        ArrayList <Integer> coins = new ArrayList <Integer>();
        while (scan.hasNextInt()) {
            int next = scan.nextInt();
            if (!coins.contains(next)) {
                num_coins++;
                coins.add(next);
            }
        }
        Collections.sort(coins);
        magic.add(new String[total]);
        for (int i = 0; i < total; i++) {
            if (coins.get(0) > i + 1) {
                magic.get(0)[i] = "0";
            } else if ((i + 1) % coins.get(0) == 0) {
                magic.get(0)[i] = "1";
            } else {
                magic.get(0)[i] = "0";
            }
            //System.out.print(magic.get(0)[i] + " ");
            
        }
        //System.out.println();
        for (int i = 1; i < num_coins; i++) {
            magic.add(new String[total]);
            
            for (int j = 0; j < total; j++) {
                if (coins.get(i) > j + 1) {
                    magic.get(i)[j] = magic.get(i - 1)[j];
                } else if (coins.get(i) == j + 1) {
                    magic.get(i)[j] = "" + (Long.parseLong(magic.get(i - 1)[j]) + 1);
                } else {
                    if ((j + 1 - coins.get(i)) < 0) {
                        magic.get(i)[j] = magic.get(i - 1)[j];
                    } else {
                        magic.get(i)[j] = "" + (Long.parseLong(magic.get(i - 1)[j]) + Long.parseLong(magic.get(i)[j - coins.get(i)]));
                    }
                }
                //System.out.print(magic.get(i)[j] + " ");
                
            }
            //System.out.println();
        }
        out.println(magic.get(num_coins - 1)[total - 1]);
        
        out.close();
    }
}


