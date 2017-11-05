import java.io.*;
import java.util.*;

class BackStrings {
    
    private static int [] array;
    
    public static void backStrings (int num, int k) {
        if (num < 1) {
            System.out.println(Arrays.toString(array));
        } else {
            for (int i = 0; i < k; i++) {
                array[num - 1] = i;
                backStrings(num - 1, k);
            }
        }
    }
    
    public static void main (String [] args) {
        array = new int [3];
        backStrings(3, 3);
    }
}