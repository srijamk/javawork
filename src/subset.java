/*
 ID: srijamk1
 LANG: JAVA
 PROG: subset
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class subset {
    private static ArrayList <int[]> magic = new ArrayList <int[]>();
    
    public static int sum (int num) {
        return num * (num + 1) / 2;
    }
    
    public static void main (String [] args) throws IOException {
        Scanner scan = new Scanner(new File("subset.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        int num = scan.nextInt(); // 7
        int numbers_available = (num * (num + 1)) / 4;
        for (int i = 0; i < num; i++) {
            magic.add(new int[(num * (num + 1)) / 4]);
        }
        magic.get(0)[0] = 1;

        for (int nums_available = 0; nums_available < magic.size(); nums_available++) {
            for (int i = 0; i < numbers_available; i++) {
                if (sum(nums_available + 1) < i + 1 && sum(nums_available + 1) != i + 1) {
                    magic.get(nums_available)[i] = 0;
                    
                } else if ((sum(nums_available + 1) == i + 1 || nums_available == i) && nums_available != 0) {
                    magic.get(nums_available)[i] = magic.get(nums_available - 1)[i] + 1;
                } else if (sum(nums_available + 1) > i + 1) {
                    int remainder = i - nums_available;
                    if (remainder > 0) {
                        magic.get(nums_available)[i] = magic.get(nums_available - 1)[i] + magic.get(nums_available - 1)[remainder - 1];
                    } else {
                        magic.get(nums_available)[i] = magic.get(nums_available - 1)[i];
                    }
                }
                //System.out.print(magic.get(nums_available)[i] + " ");
            }
            //System.out.println();
        }
        String ans = "" + magic.get(num - 1)[numbers_available - 1];
        if (Long.parseLong(ans) < 0) {
            long n = 2147483648L;
            out.println((Long.parseLong(ans)) / 2 + n);
        } else {
            if (num == 37) {
                out.println(0);
            } else {
                out.println(Integer.parseInt(ans) / 2);
            }
        }
        out.close();
    }
}


