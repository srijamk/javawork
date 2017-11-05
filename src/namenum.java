/*
ID: srijamk1
LANG: JAVA
PROG: namenum
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;
import java.util.HashMap;

class namenum {
    public static long create_name (String name) {
        String result = "";
        for (int letter = 0; letter < name.length(); letter++) {
            if (name.charAt(letter) == 'A' || name.charAt(letter) == 'B' || name.charAt(letter) == 'C') {
                result += "2";
            } else if (name.charAt(letter) == 'D' || name.charAt(letter) == 'E' || name.charAt(letter) == 'F') {
                result += "3";
            } else if (name.charAt(letter) == 'G' || name.charAt(letter) == 'H' || name.charAt(letter) == 'I') {
                result += "4";
            } else if (name.charAt(letter) == 'J' || name.charAt(letter) == 'K' || name.charAt(letter) == 'L') {
                result += "5";
            } else if (name.charAt(letter) == 'M' || name.charAt(letter) == 'N' || name.charAt(letter) == 'O') {
                result += "6";
            } else if (name.charAt(letter) == 'P' || name.charAt(letter) == 'R' || name.charAt(letter) == 'S') {
                result += "7";
            } else if (name.charAt(letter) == 'T' || name.charAt(letter) == 'U' || name.charAt(letter) == 'V') {
                result += "8";
            } else if (name.charAt(letter) == 'W' || name.charAt(letter) == 'X' || name.charAt(letter) == 'Y') {
                result += "9";
            }
        }
        return Long.parseLong(result);
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        BufferedReader g = new BufferedReader(new FileReader("dict.txt"));
        HashMap<Integer, String[]> names = new HashMap<Integer, String[]>();
        boolean return_none = true;
        String name = f.readLine();
        String [] two_ = {"A", "B", "C"};
        String [] three_ = {"D", "E", "F"};
        String [] four_ = {"G", "H", "I"};
        String [] five_ = {"J", "K", "L"};
        String [] six_ = {"M", "N", "O"};
        String [] seven_ = {"P", "R", "S"};
        String [] eight_ = {"T", "U", "V"};
        String [] nine_ = {"W", "X", "Y"};
        names.put(2, two_);
        names.put(3, three_);
        names.put(4, four_);
        names.put(5, five_);
        names.put(6, six_);
        names.put(7, seven_);
        names.put(8, eight_);
        names.put(9, nine_);
        for (int x = 1; x <= 4617; x++) {
            String possible_name = g.readLine();
            if (create_name(possible_name) == Long.parseLong(name)) {
                out.println(possible_name);
                return_none = false;
            }
        }
        if (return_none) {
            out.println("NONE");
        }
        out.close();
    }
}
