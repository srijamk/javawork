import java.io.*;
import java.util.*;

class IsSorted {
    public static boolean isSorted (int [] arr, int start) {
        if (start == arr.length - 1) {
            return true;
        }
        return (arr[start] <= arr[start + 1]) && isSorted(arr, start + 1);
    }
    public static void main (String [] args) {
        int [] arr = {1, 2, 3, 5, 4};
        System.out.println(isSorted(arr, 0));
    }
}