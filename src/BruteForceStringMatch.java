import java.io.*;
import java.util.*;

class BruteForceStringMatch {
    
    public static String bruteForce (String T, int n, String P, int m) {
        for (int i = 0; i <= n - m; i++) {
            int j = 0;
            while (j < m && T.charAt(i + j) == P.charAt(j)) {
                j++;
                
            }
            if (j == m) {
                return "Found";
            }
        }
        return "Not Found";
    }
    
    public static void main (String [] args) {
        System.out.println(bruteForce ("hello world", 11, "world", 5));
    }
}