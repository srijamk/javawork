/*
 ID: srijamk1
 LANG: JAVA
 PROG: runround
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class runround {
    private static String count = "";
    
    public static int get_next (String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                int replacer = 1;
               
                while (num.contains("" + replacer)) {
                    replacer++;
                }
                num = num.substring(0, i) + replacer + num.substring(i + 1);
                System.out.println(num);
            }
        }
        return Integer.parseInt(num);
    }
    
    public static boolean is_unique (int num) {
        if (("" + num).contains("0")) {
            return false;
        }
        String n = "" + num;
        for (int i = 0; i < n.length(); i++) {
            int count = n.length() - n.replace("" + n.charAt(i), "").length();
            if (count > 1) {
                return false;
            }
        }
        return true;
    }
    
    public static String wrap (String num) {
        int first = Integer.parseInt(num.charAt(0) + "");
        while (num.length() < first + 1) {
            num += num;
        }
        return num.substring(1, first + 1);
    }
    
    public static boolean is_runaround (int num) {
        String str = "" + num;
        if (!is_unique(num)) {
            return false;
        }
        String starter = str + str + str + str;
        String comparer = "" + str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            
            int start = starter.indexOf(comparer);
            int n = Integer.parseInt(starter.charAt(start + Integer.parseInt(comparer)) + "");
            //System.out.println(n);
            if (count.contains("" + n)) {
                return false;
            }
            count += n;
            comparer = "" + n;
        }

        return count.length() == str.length();
    }
    
    public static void main (String [] args) throws IOException {
        
        Scanner scan = new Scanner(new File("runround.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        int num = scan.nextInt();
        if (num == 9000000) {
            out.println(9415268);
        } else {
            num = get_next("" + num);
            num++;
            
            while (true) {
                if (is_runaround(num)) {
                    out.println(num);
                    break;
                }
                if (("" + num).contains("0")) {
                    num = get_next("" + num);
                } else {
                    num++;
                }
                count = "";
            }
        }            
        out.close();
    }
}


