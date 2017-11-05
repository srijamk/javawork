/*
 ID: srijamk1
 LANG: JAVA
 PROG: pprime
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class pprime {
    public static boolean is_prime (String new_num) {
        if (Integer.parseInt("" + new_num.charAt(new_num.length() - 1)) % 2 == 0) {
            return false;
        }
        
        int num = Integer.parseInt(new_num);
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean is_palindrome (String num) {
        if (num.length() <= 1) {
            return true;
        }
        return (num.charAt(0) == num.charAt(num.length() - 1)) && is_palindrome(num.substring(1, num.length() - 1));
    }
    
    public static String create_pal (String num) {
        String top, rev;
        if (num.length() % 2 == 0) {
            top = num.substring(0, num.length() / 2);
            rev = new StringBuffer(top).reverse().toString();
        } else {
            top = num.substring(0, num.length() / 2 + 1);
            rev = new StringBuffer(top).reverse().toString().substring(1);
        }
        return top + rev;
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        String [] line = f.readLine().split(" ");
        int int_lo = Integer.parseInt(line[0]);
        int int_hi = Integer.parseInt(line[1]);
        String lo = "" + int_lo;
        for (int i = int_lo; i <= int_hi; i += Math.pow(10, lo.length() / 2)) {
            
            lo = "" + i;
            if (!(lo.charAt(0) % 2 == 0)) {
                String pal = create_pal("" + i);
                //System.out.println(i + " " + pal);
                if (is_prime(pal) && Integer.parseInt(pal) <= int_hi) {
                    out.println(pal);
                }                
            }
            
        }
        out.close();
    }
}