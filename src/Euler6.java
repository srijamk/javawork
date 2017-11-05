import java.io.*;
import java.util.*;

class Euler6 {
    public static void main (String [] args) {
        // Find sum of the squares
        int sum_squares = 0;
        for (int i = 1; i <= 100; i++) {
            sum_squares += i * i;
        }
        // Find square of the sum
        int sum = (100 * 101 / 2);
        int square_sum = sum * sum;
        
        // Add
        System.out.println(square_sum - sum_squares);
        
        // Answer: 25164150
    }
}