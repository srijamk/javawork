import java.io.*;
import java.util.*;
import java.util.Arrays;
// Imports package containing readInt, StdIn, and StdOut
import edu.princeton.cs.algs4.*;


class BinarySearch {
    public static int indexOf(int[] arr, int number) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (number < arr[mid]) {
                hi = mid - 1;
            } else if (number > arr[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
    public static void main (String [] args) {
        In in = new In(args[0]);
        int [] whitelist = in.readAllInts();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (BinarySearch.indexOf(whitelist, key) == -1) {
                StdOut.println(key);
            }
        }
        
    }
}