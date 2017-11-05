/*
 ID: srijamk1
 LANG: JAVA
 PROG: sprime
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;
import java.lang.Math;

class sprime {
    public static boolean is_prime (int new_num) {
        if (new_num == 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(new_num); i++) {
            if (new_num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        int length = Integer.parseInt(f.readLine());
        Stack<Integer> parents = new Stack<Integer>();
        int[] first_nums = {2, 3, 5, 7};
        for (int j = 0; j < 4; j++) {
            parents.push(first_nums[j]);
            while (!parents.isEmpty()) {
                int num = parents.pop();
                //System.out.println(num);
                if (("" + num).length() == length) {
                    if (is_prime(num)) {
                        out.println(num);
                    }
                } else {
                    for (int i = 9; i >= 1; i-=2) {
                        int n = Integer.parseInt(num + (i + ""));
                        if (is_prime(n)) {
                            parents.push(n);
                        }
                    }
                }
            }
        }
        out.close();
    }
}

class Stack<Item> {
    
    private Node first;
    private static int count = 0;
    
    private class Node {
        Item item;
        Node next; 
    }
    
    public static int size() {
        return count;
    }
    
    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }
    
    public void push (Item elem) {
        Node oldfirst = first;
        first = new Node();
        first.item = elem;
        first.next = oldfirst;
        count++;
    }
    
    public Item peek() {
        return first.item;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
}
