/*
ID: srijamk1
LANG: JAVA
PROG: dualpal
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;

class dualpal {
    public static boolean is_palindrome(long num) {
        String number = "" + num;
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
        }
        highest_power = highest_power / base;
        while (highest_power >= 1) {
            ans += "" + num / highest_power;
            num = num % highest_power;
            highest_power /= base;
        }
        return ans;
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        String [] list = f.readLine().split(" ");
        int range = Integer.parseInt(list[0]);
        int start = Integer.parseInt(list[1]);
        int count = 1;
        for (int i = start + 1; count <= range; i++) {
            boolean is_printable = false;
            boolean is_also_printable = false;
            for (int base = 2; base <= 10; base++) {
                if (is_palindrome(Long.parseLong(change_base(i, base))) && !(is_printable)) {
                    is_printable = true;
                } else if (is_palindrome(Long.parseLong(change_base(i, base))) && is_printable) {
                    out.println(i);
                    count++;
                    break;
                }
            }
                //System.out.println(i + ": " + change_base(i, base));
        }
        out.close();
    }
}

