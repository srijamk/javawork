import java.io.*;
import java.util.*;

class SumArray {
    public static int [] sum (int start, int [] list) {
        if (start == list.length) {
            return list;
        } 
        list[start + 1] += list[start];
        return sum(start + 1, list);
    }
    public static void main (String [] args) {
        int [] nums = {1, 2, 3, 4, 5, 6};
        nums = sum(0, nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

