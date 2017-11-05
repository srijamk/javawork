/*
 ID: srijamk1
 LANG: JAVA
 PROG: nocows
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;

class nocows {
    private static int nodes = 0;
    private static int height = 0;
    private static long count = 0;
    //private static ArrayList <String> arr = new ArrayList <String>();
    private static HashMap <String, Integer> a = new HashMap <String, Integer>();

    
    /*
     public static void main (String [] args) throws IOException {
     Scanner scan = new Scanner(new File("nocows.in"));
     PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
     nodes = scan.nextInt();
     height = scan.nextInt();
     //magic(1, 1, 1, 1);
     Stack <String> s = new Stack <String> ();
     String start = "1 1 1";
     s.push(start);
     a.put(start, new Long(1));
     long count = 0;
     
     while (!s.isEmpty()) {
     
     String t = s.pop();
     
     String[] test = t.split(" ");
     if (Integer.parseInt(test[1]) % 2 != 0) {
     //if (!a.containsKey("" + test[0] + " " + test[1] + " " + test[2])) {
     
     if (Integer.parseInt(test[0]) == height && Integer.parseInt(test[1]) == nodes) {
     //System.out.println(t + " " + a.get(t));
     a.put("" + test[0] + " " + test[1] + " " + test[2], a.get(t));
     count += a.get(t);
     
     } else if (Integer.parseInt(test[0]) > height || Integer.parseInt(test[1]) > nodes || Integer.parseInt(test[1]) > Math.pow(2, Integer.parseInt(test[0])) - 1) {
     
     } else {
     
     //System.out.println(t);
     int pre_first = Integer.parseInt(test[0]);
     int pre_sec = Integer.parseInt(test[1]);
     int available = Integer.parseInt(test[2]);
     //System.out.println(t + " " + a.get(t) + " " + available);
     for (int i = 1; i <= available; i++) {
     
     if (i == available) {
     a.put("" + (pre_first + 1) + " " + (pre_sec + i * 2) + " " + (i * 2), a.get(t));
     } else {
     a.put("" + (pre_first + 1) + " " + (pre_sec + i * 2) + " " + (i * 2), a.get(t) * (factorial(available)/(factorial(available - i) * factorial(i))));
     
     
     }
     s.push("" + (pre_first + 1) + " " + (pre_sec + i * 2) + " " + (i * 2));
     
     }
     }
     }
     }
     
     System.out.println(count % 9901);
     //System.out.println(count % 9901);
     out.close();
     
     }
     */
    public static void main (String [] args) throws IOException {
        Scanner scan = new Scanner(new File("nocows.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
        int nodes = scan.nextInt();
        int height = scan.nextInt();  
        if (nodes == height && nodes == 1) {
            System.out.println(1);
        } else if (nodes == 3 && height == 2) {
            System.out.println(1);
        } else if (nodes > Math.pow(2, height) - 1) {
            System.out.println(0);
        } else {
            int i = 0;
            while (nodes > Math.pow(2, i) - 1) {
                a.put(nodes + " " + i, 0);
                i++;
                
            }
            i--;
            while (i != height) {
                i++;
                if (nodes == i * 2 - 1) {
                    a.put(nodes + " " + i, (int)Math.pow(2, height - 2));
                }
            }
            out.println(a.get(nodes + " " + height));
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