/*
 ID: srijamk1
 LANG: JAVA
 PROG: zerosum
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;

class zerosum {
   
    private static HashMap <String, Integer> sums = new HashMap <String, Integer>();
    private static ArrayList <String> a = new ArrayList <String>();
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
        int num = Integer.parseInt(f.readLine());
        String start = "1";
        
        Stack <String> s = new Stack <String>();
        s.push(start);
        sums.put(start, 1);
        while (!s.isEmpty()) {
            String test = s.pop();
            int last_digit = Integer.parseInt("" + test.charAt(test.length() - 1));
            if (last_digit == num && sums.get(test) == 0) {
                a.add(test);
            } else if (last_digit != num) {
                String new_test = test + "+" + (last_digit + 1);
                sums.put(new_test, sums.get(test) + (last_digit + 1));
                s.push(new_test);
                new_test = test + "-" + (last_digit + 1);
                sums.put(new_test, sums.get(test) - (last_digit + 1));
                s.push(new_test);
                if (last_digit < num - 1) {
                    //System.out.println(test);
                    new_test = test + "+" + (last_digit + 1) + " " + (last_digit + 2);
                    sums.put(new_test, sums.get(test) + Integer.parseInt("" + (last_digit + 1) + "" + (last_digit + 2)));
                    s.push(new_test);
                    new_test = test + "-" + (last_digit + 1) + " " + (last_digit + 2);
                    sums.put(new_test, sums.get(test) - Integer.parseInt("" + (last_digit + 1) + "" + (last_digit + 2)));
                    s.push(new_test);
                }
                
            }
        }
        s.push("1 2");
        sums.put("1 2", 12);
        while (!s.isEmpty()) {
            String test = s.pop();
            int last_digit = Integer.parseInt("" + test.charAt(test.length() - 1));
            if (last_digit == num && sums.get(test) == 0) {
                a.add(test);
            } else if (last_digit != num) {
                String new_test = test + "+" + (last_digit + 1);
                sums.put(new_test, sums.get(test) + (last_digit + 1));
                s.push(new_test);
                new_test = test + "-" + (last_digit + 1);
                sums.put(new_test, sums.get(test) - (last_digit + 1));
                s.push(new_test);
                if (last_digit < num - 1) {
                    //System.out.println(test);
                    new_test = test + "+" + (last_digit + 1) + " " + (last_digit + 2);
                    sums.put(new_test, sums.get(test) + Integer.parseInt("" + (last_digit + 1) + "" + (last_digit + 2)));
                    s.push(new_test);
                    new_test = test + "-" + (last_digit + 1) + " " + (last_digit + 2);
                    sums.put(new_test, sums.get(test) - Integer.parseInt("" + (last_digit + 1) + "" + (last_digit + 2)));
                    s.push(new_test);
                }
                
            }
        }      
        Collections.sort(a);
        for (String bleh: a) {
            out.println(bleh);
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