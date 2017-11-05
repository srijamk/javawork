import java.util.*;
import java.io.*;

class Fib {
    private static int size = 6;
    private static int [] arr = new int [size + 1];
    public static int bottom_up (int n) {
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        
        return arr[size - 1];
    }
     
    public static int top_down (int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        return arr[n - 1] = top_down(n - 1) + top_down(n - 2);
        chrome
        //return arr[size - 1];
    }
    
    public static void main (String [] args) {
        //size = 3;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(bottom_up(6));
    }
}