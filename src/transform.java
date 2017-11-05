/*
ID: srijamk1
LANG: JAVA
PROG: transform
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class transform {
    public static String swap_line (String line) {
        String result = "";
        for (int i = line.length() - 1; i >= 0; i--) {
            result += line.charAt(i);
        }
        return result;
    }
    
    public static boolean check_same (ArrayList <String> pattern, ArrayList <String> compare_pattern) {
        for (int line = 0; line < pattern.size(); line++) {
            for (int letter = 0; letter < pattern.get(0).length(); letter++) {
                if (compare_pattern.get(line).charAt(letter) != pattern.get(line).charAt(letter)) {
                    return false;
                }
            }
        }
        return true;
    }
    public static ArrayList <String> one (ArrayList <String> pattern) {
        ArrayList <String> new_pattern = new ArrayList <String> ();
        for (int last_char = 0; last_char <= pattern.size() - 1; last_char++) {
            String new_line = "";
            for (int line = pattern.size() - 1; line >= 0; line--) {
                new_line += pattern.get(line).charAt(last_char);
            }
            new_pattern.add(new_line);
        }
        return new_pattern;
    }
    public static ArrayList <String> two (ArrayList <String> pattern) {
        ArrayList <String> new_pattern = new ArrayList <String> ();
        for (int line_pos = pattern.size() - 1; line_pos >= 0; line_pos--) {
            new_pattern.add(swap_line(pattern.get(line_pos)));
        }
        return new_pattern;
    }
    public static ArrayList <String> three (ArrayList <String> pattern) {
        ArrayList <String> new_pattern = new ArrayList <String> ();
        for (int last_char = pattern.size() - 1; last_char >= 0; last_char--) {
            String new_line = "";
            for (int line = 0; line <= pattern.size() - 1; line++) {
                new_line += pattern.get(line).charAt(last_char);
            }
            new_pattern.add(new_line);
        }
        return new_pattern;
    }    
    public static ArrayList <String> four (ArrayList <String> pattern) {
        ArrayList <String> new_pattern = new ArrayList <String> ();
        for (int line = 0; line < pattern.size(); line++) {
            new_pattern.add(swap_line(pattern.get(line)));
        }
        return new_pattern;
    }
    public static boolean five (ArrayList <String> pattern, ArrayList <String> compare_pattern) {
        ArrayList <String> new_pattern = four(pattern);
        return check_same(one(new_pattern), compare_pattern) || check_same(two(new_pattern), compare_pattern) || check_same(three(new_pattern), compare_pattern);
    }
    public static boolean six (ArrayList <String> pattern, ArrayList <String> compare_pattern) {
        return check_same(pattern, compare_pattern);
    }

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        ArrayList <String> pattern = new ArrayList <String> ();
        ArrayList <String> compare_pattern = new ArrayList <String> ();
        int num_of_lines = Integer.parseInt(f.readLine());
        ArrayList <String> line = new ArrayList <String>();
        for (int time = 1; time <= num_of_lines; time++) {
            String read_line = f.readLine();
            pattern.add(read_line);
        }

        for (int time = 1; time <= num_of_lines; time++) {
            String read_line = f.readLine();
            compare_pattern.add(read_line);
        }
        if (check_same(one(pattern), compare_pattern)) {
            out.println(1);
        }
        else if (check_same(two(pattern), compare_pattern)) {
            out.println(2);
        }
        else if (check_same(three(pattern), compare_pattern)) {
            out.println(3);
        }
        else if (check_same(four(pattern), compare_pattern)) {
            out.println(4);
        }
        else if (five(pattern, compare_pattern)) {
            out.println(5);
        }
        else if (six(pattern, compare_pattern)) {
            out.println(6);
        }
        else {out.println(7);}

        out.close();
    }
}