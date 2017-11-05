import java.io.*;
import java.util.*;

class Euler7 {
    public static boolean isPrime (long num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main (String [] args) {
        int count = 0;
        long i = 2;
        while (count <= 10001) {
            if (isPrime(i)) {
                count++;
            }
            i++;
        }
        System.out.println(i - 1);
        // Answer: 104743
    }
}

