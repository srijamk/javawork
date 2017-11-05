import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;
import java.lang.Math;
class DrawLines {
    public static void main (String [] args) {
        int N = Integer.parseInt(args[0]);
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N*N);
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < N; i+=1) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * i);
            StdDraw.point(i, Math.log(i));
        }
    }
}