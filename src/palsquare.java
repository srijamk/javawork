/*
ID: srijamk1
LANG: JAVA
PROG: palsquare
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

class palsquare {
    public static boolean is_palindrome(String num) {
        String number = num;
        for (int i = 0; i <= number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
    public static String change_base (long num, int base) {
        String ans = "";
        int highest_power = 1;
        if (num != 0 && num != 1) {
            while (highest_power <= num) {
                highest_power *= base;
            }
        } else {
            return "" + num;
        }
        highest_power = highest_power / base;
        while (highest_power >= 1) {
            if ((num / highest_power) >= 10) {
                ans += (char) ((num / highest_power) + 55);
            } else {
                ans += "" + num / highest_power;
            }
            num = num % highest_power;
            highest_power /= base;
        }
        return ans;
    }    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(f.readLine());
        for (int i = 1; i <= 300; i++) {
            //System.out.println(i + ": " + change_base((long)i, base));
            if (is_palindrome(change_base((long)Math.pow(i, 2), base))) {
                out.println(change_base((long)i, base) + " " + change_base((long)Math.pow(i, 2), base));
            }
        }
        out.close();
    }
}
