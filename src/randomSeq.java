import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;

class randomSeq {

    public static void main (String[] args) {
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            int rand = StdRandom.uniform(n);
            StdOut.println(rand);
        }
    }
}