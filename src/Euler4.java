import java.io.*;
import java.util.*;

class Euler4 {
    public static String reverse (String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
    
    public static void main (String [] args) {
        int highest = 0;
        for (int x = 999; x > 0; x--) {
            for (int y = 999; y > 0; y--) {
                String num =("" + (x * y)); 
                if (num.equals(reverse(num)) && Integer.parseInt(num) > highest) {
                    highest = Integer.parseInt(num);
                }
                
            }        
        }
        System.out.println(highest);
        // Answer: 906609
    }
}