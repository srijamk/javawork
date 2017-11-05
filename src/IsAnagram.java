import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
class IsAnagram {
    public static boolean is_anagram (char[] first, char[] second) {
        int ascii = 255;
        if (first.length != second.length) {
            return false;
        }
        int [] first_count = new int [ascii];
        int [] second_count = new int [ascii];
        
        for (int i = 0; i < first.length; i++) {
            // get char value at first
            int val = first[i];
            
            // store the count of val in first_count as it contains the index of all ascii chars
            first_count[val] += 1;
        }
        
        for (int i = 0; i < second.length; i++) {
            // get char value at first
            int val = second[i];
            
            // store the count of val in first_count as it contains the index of all ascii chars
            second_count[val] += 1;
        }
        for (int i = 0; i < first_count.length; i++) {
            if (first_count[i] != second_count[i]) {
                return false;
            }
        }
        return true;

    }
    
    public static boolean is_anagram2 (char[] first, char[] second) {
        Arrays.sort(first);
        Arrays.sort(second);
        if (first.length != second.length) {
            return false;
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main (String [] args) {
        char [] first = args[0].toCharArray();
        char [] second = args[1].toCharArray();
        StdOut.println(is_anagram(first, second));
    }
}