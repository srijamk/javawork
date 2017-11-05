import java.util.*;
import java.io.*;

class BackBinary {
     
    private static int [] bits;
    public static void binary (int num) {
        if (num < 1) {
            System.out.println(Arrays.toString(bits)); //Print the existing array
        } else {
            bits[num - 1] = 0;
            binary (num - 1);
            bits[num - 1] = 1;
            binary (num - 1);
        }
    }
    
    public static void main (String [] args) {
        bits = new int [3];
        binary(3);
    }
}