import java.io.*;
import java.util.*;
import java.util.Arrays;
// Imports package containing readInt, StdIn, and StdOut
import edu.princeton.cs.algs4.*;

class Average {
    public static void main (String [] args) {
        int count = 0;
        double sum = 0;
        while (!StdIn.isEmpty()) {
            double new_num = StdIn.readDouble();
            count++;
            sum += new_num;
            StdOut.println(sum / count);
        }
    }
}