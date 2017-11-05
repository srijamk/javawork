/*
ID: srijamk1
LANG: JAVA
PROG: beads
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class beads {
    public static int count_beads (String s) {
        int count = 0;
        if (s.length() > 0) {
            char color = s.charAt(0);
            int color_index = 0;
            while (color_index < s.length()) {
                if (s.charAt(color_index) != 'w') {
                    color = s.charAt(color_index);
                    break;
                }
                color_index++;
            }
            int i = 0;
            while ((i < s.length()) && (s.charAt(i) == 'w' || s.charAt(i) == color)) {
                count++;
                i++;
            }
        }
        return count;
    }
    public static String reverse_beads (String s) {
        String return_beads = "";
        if (s.length() > 0) {
            for (int i = s.length() - 1; i >= 0; i--) {
                return_beads += s.charAt(i);
            }
        }
        return return_beads;
    }
    public static boolean is_dup (String s) {
        char check = s.charAt(0);
        for (int c = 0; c < s.length(); c++) {
            if (s.charAt(c) != s.charAt(0)) {
                return false;
            }
        }
        return true;
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int number_of_beads = Integer.parseInt(f.readLine());
        String beads = f.readLine();
        int highest_total = 0;
        int return_index = 0;
        for (int breakpoint = 0; breakpoint < beads.length(); breakpoint++) {
            String first_part = beads.substring(0, breakpoint);
            
            String second_part = beads.substring(breakpoint) + beads.substring(0, breakpoint);
            int subtotal = count_beads(reverse_beads(first_part)) + count_beads(second_part);
            if (subtotal >= highest_total) {
                highest_total = subtotal;
                return_index = breakpoint;
            }
            
        }
        if ((beads.length() < highest_total - 1) || (is_dup(beads))) {
            highest_total = beads.length();
        }
        out.println(highest_total);
        out.close();
    }
}