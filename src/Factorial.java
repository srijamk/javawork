import java.io.*;
import java.util.*;

class Factorial {
    public static int Fact (int n) {
        int m = n * n;
        if (m == 1) {
            return 1;
        }
        return m * Fact(m - 1);
    }
    public static void main (String [] args) {
        System.out.println(Fact(2));
    }
}