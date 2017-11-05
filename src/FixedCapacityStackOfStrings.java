import java.io.*;
import java.util.*;
import edu.princeton.cs.algs4.*;

class FixedCapacityStackOfStrings {
    private static String [] arr;
    private int count = 0;
    public FixedCapacityStackOfStrings(int num) {
        arr = new String [num];
    }
    public boolean isEmpty() {
        return count == 0;
    }
    public void push(String item) {
        arr[count++] = item;
    }
    public String pop() {
        String elem = peek();
        arr[--count] = null;
        return elem;
    }
    public int size() {
        return count;
    }
    public String peek() {
        return arr[count - 1];
    }
    public static boolean isBalanced (String s) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings (100);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push("" + s.charAt(i));
            } else {
                return false;
            }
        }
        return stack.size() == 0;
    }
    public static String ToInteger (int n) {
        String result = "";
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings (100);
        while (n > 0) {
            stack.push("" + n % 2);
            n /= 2;
        }
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
    public static void main (String [] args) {
        System.out.println(isBalanced("(()()()))"));
        System.out.println(ToInteger(16));
    }
}
