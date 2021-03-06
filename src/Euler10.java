import java.io.*;
import java.util.*;
import java.lang.Math;

class Euler10 {

    public static boolean isPrime (long num) {
        for (int i = 2; i < Math.sqrt(num) + 1; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static long sum () {
        long sum = 0;
        for (int i = 3; i < 2000000; i++) {
            if (isPrime(i)) {
                sum += i;
            }
        }
        return sum;
    }
    public static void main (String [] args) {
        System.out.println(sum() + 2);
        // Answer: 142913828922
    }
}
