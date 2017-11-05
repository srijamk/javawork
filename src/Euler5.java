import java.io.*;
import java.util.*;

class Euler5 {
    public static boolean isValid (int num) {
        for (int i = 1; i <= 20; i++) {
            if (num % i != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main (String [] args) {
        int x = 5000;
        while (true) {
            if (isValid(x)) {
                System.out.println(x);
                break;
            }
            x++;
        }
    }
    // Answer: 232792560
}