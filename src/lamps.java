/*
 ID: srijamk1
 LANG: JAVA
 PROG: lamps
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
//import java.util.Arrays;
//import java.util.ArrayList;

class lamps {
    
    private static ArrayList <Integer> ons = new ArrayList <Integer>();
    private static ArrayList <Integer> offs = new ArrayList <Integer>();
    private static int C = 0;
    private static boolean impossible = true;
    private static ArrayList <String> set = new ArrayList <String>();
    private static String lamps = "";
    private static String printer = "";
    public static boolean is_valid (String result, ArrayList <Integer> ons, ArrayList <Integer> offs) {
        for (int i: ons) {
            if (result.charAt(i) != '1') {
                return false;
            }
        }
        for (int i: offs) {
            if (result.charAt(i) != '0') {
                return false;
            }        
        }
        return true;
    }
    
    public static void magic (String start, int cur) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        if (C < 4) {
            for (int i = 0; i < C; i++) {
                for (int j = 0; j < C; j++) {
                    for (int k = 0; k < C; k++) {
                        for (int l = 0; l < C; l++) {
                            String test = apply(apply(apply(apply(start, i), j), k), l);
                            if (is_valid(test, ons, offs) && !set.contains(test)) {
                                set.add(test);
                                Collections.sort(set);
                            }
                        }
                    }
                }
            }            
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 4; k++) {
                        for (int l = 0; l < 4; l++) {
                            String test = apply(apply(apply(apply(start, i), j), k), l);
                            if (is_valid(test, ons, offs) && !set.contains(test)) {
                                set.add(test);
                                Collections.sort(set);
                            }
                        }
                    }
                }
            }
        }
        for (String s: set) {
            out.println(s);
        }
        if (is_valid(lamps, ons, offs) && !set.contains(lamps)) {
            out.println(lamps);
        } else {
            if (set.size() == 0) {
                out.println("IMPOSSIBLE");
            }
        }
        out.close();
    }
    
    public static String apply (String result, int num) {
        String ans = "";
        if (num <= 2) {
            for (int i = 0; i < result.length(); i++) {
                if (i % 2 == num % 2 || num == 0) {
                    ans += 1 - Integer.parseInt(result.charAt(i) + "");
                } else {
                    ans += Integer.parseInt(result.charAt(i) + "");
                }
                
                
            }            
        } else {
            for (int i = 0; i < result.length(); i++) {
                if (i % 3 == 0) {
                    ans += 1 - Integer.parseInt(result.charAt(i) + "");
                } else {
                    ans += Integer.parseInt(result.charAt(i) + "");
                }
                
            }             
        }
        
        return ans;
    }
    
    public static void print (ArrayList <String> s) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        for (String i: s) {
            out.print(i + " ");
        }
        out.println();
    }    
    
    public static void main (String [] args) throws IOException {
        Scanner scan = new Scanner(new File("lamps.in"));
        Scanner check_scan = new Scanner (new File ("lamps.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        int n = scan.nextInt();
        C = scan.nextInt();
        for (int i = 0; i < n; i++) {
            lamps += "1";
        }        
        
        int first = scan.nextInt();
        while (first != -1) {
            if (first != -1) {
                
                ons.add(first - 1);
            }
            first = scan.nextInt();
        }
        
        int second = scan.nextInt();
        while (second != -1) {
            if (second != -1) {
                offs.add(second - 1);
            }
            second = scan.nextInt();
        } 
        magic (lamps, 0);
        /*
         if (set.size() == 0) {
         out.println("IMPOSSIBLE");
         } else {
         Collections.sort(set);
         for (String i: set) {
         out.println(i);
         }
         }
         if (is_valid(lamps, ons, offs) && !set.contains(lamps)) {
         out.println(lamps);
         }        
         */
        /*
         HashMap <Integer, ArrayList <String>> map = new HashMap <Integer, ArrayList <String>>();
         ArrayList <String> new_lst = new ArrayList <String>();
         for (int i = 0; i <= 3; i++) {
         new_lst.add(apply(lamps, i));
         }
         map.put(1, new_lst);
         //System.out.println(is_valid("10001000100010001000100010001000100010001000100010", ons, offs));
         for (int i = 2; i <= C; i++) {
         ArrayList <String> new_l = new ArrayList <String>();
         
         for (String s: map.get(i - 1)) {
         for (int a = 0; a <= 3; a++) {
         String add = apply(s, a);
         if (!new_l.contains(add)) {
         new_l.add(add);
         }
         }
         }
         //print(new_l);
         map.put(i, new_l);
         }
         if (C == 0 && offs.size() == 0) {
         out.println("1111111111");
         } else if (C == 0) {
         out.println("IMPOSSIBLE");
         } else {
         Collections.sort(map.get(C));
         for (String test: map.get(C)) {
         if (ons.size() == 0 && offs.size() == 0) {
         out.println(test);
         } else {
         if (is_valid(test, ons, offs)) {
         out.println(test);
         }
         }
         }
         }
         */
        out.close();
        
        
        
        
    }
    
}
