import java.io.*;
import java.util.*;

class Euler2 {
    public static void main (String [] args) {
        int x = 1;
        int y = 2;
        int sum = 0;
        while (x < 4000000 && y < 4000000) {
            if (x % 2 == 0) {
                sum += x;
            }
            x = x + y;
            if (y % 2 == 0) {
                sum += y;
            }
            y = x + y;
        }
        System.out.println(sum);
    }
    // Answer: 4613732
}