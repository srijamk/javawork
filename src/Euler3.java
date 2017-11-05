import java.io.*;
import java.util.*;
import java.lang.Math;

class Euler3 {
    public static boolean isPrime (long num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main (String [] args) {
        long highest = 0;
        long i = 1;
        long num = 600851475143L;
        while (i < num / 2) {
            if (num % i == 0 && isPrime(i)) {
                if (i > highest) {
                    highest = i;
                }
               
            }
            i++;
        }
        System.out.println(highest);
    }
    // Answer: 6857
}