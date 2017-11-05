import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;

class DrawHistogram {
    public static void main (String [] args) {
        int N = Integer.parseInt(args[0]);
        double [] a = new double [N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(N);
        }
        for (int i = 0; i < N; i++) {
            double x = 1.0 * i/N;
            int y = 1;
            double hw = a[i] / 2.0;
            double hh = a[i] / 2.0;
            StdDraw.filledRectangle(x, y, hw, hh);
        }
    }
}