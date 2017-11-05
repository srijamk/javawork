/*
 ID: srijamk1
 LANG: JAVA
 PROG: sort3
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class sort3 {
    
    public static boolean is_sorted (int [] lst) {
        for (int i = 0; i < lst.length - 2; i++) {
            if (lst[i] > lst[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    public static int magic (int [] lst) {
        if (is_sorted(lst)) {
            
            return 0;
        } else {
            int[] dup = lst.clone();
            for (int i = 0; i < lst.length; i++) {
                for (int j = 0; j < lst.length; j++) {
                    if (!is_wrong(dup, i) && !is_wrong(dup, j)) {
                        
                        swap(i, j, dup);
                        print(dup);
                        return 1 + magic(dup);
                    }
                    
                }
            }
        }
        return magic (lst);
    }
    
    
    public static void swap (int a, int b, int [] lst) {
        int temp = lst[b];
        lst[b] = lst[a];
        lst[a] = temp;
    }
    
    public static void print (int[] lst) {
        for (int i = 0; i < lst.length; i++) {
            System.out.print(lst[i] + " ");
        }
        System.out.println();
    }
    
    public static void p (ArrayList <String> lst) {
        for (String s: lst) {
            System.out.println(s);
        }
    }
    
    public static boolean is_wrong (int[] lst, int j) {
        int one_count = 0;
        int two_count = 0;
        int three_count = 0;
        for (int i = 0; i < lst.length - 1; i++) {
            if (lst[i] == 1) {
                one_count++;
            }
            if (lst[i] == 2) {
                two_count++;
            }
        }
        if (lst[j] == 1) {
            return j < one_count;
        } else if (lst[j] == 2) {
            return j >= one_count && j < one_count + two_count;
        }
        return j >= one_count + two_count;
    }
    
    public static ArrayList <Integer> ones (int [] lst, int one_count) {
        ArrayList <Integer> result = new ArrayList <Integer>();
        
        for (int i = lst.length - 1; i >= one_count; i--) {
            if (lst[i] == 1) {
                result.add(i);
                
            }
        }
        return result;
    }
    
    public static ArrayList <Integer> twos (int [] lst, int one_count, int two_count) {
        ArrayList <Integer> result = new ArrayList <Integer>();
        
        
        for (int i = lst.length - 1; i >= one_count + two_count; i--) {
            if (lst[i] == 2) {
                result.add(i);
            }
        }
        for (int i = one_count - 1; i >= 0; i--) {
            if (lst[i] == 2) {
                result.add(i);
            }
        }
        return result;
    }
    public static ArrayList <Integer> dup_threes (int [] lst, int one_count, int two_count) {
        ArrayList <Integer> result = new ArrayList <Integer>();
        if (one_count + two_count == lst.length) {
            return result;
        }
        for (int i = 0; i <= one_count + two_count; i++) {
            if (lst[i] == 3) {
                result.add(i);
                
            }
        }
        return result;
    }
    
    public static ArrayList <Integer> dup_twos (int [] lst, int one_count, int two_count) {
        ArrayList <Integer> result = new ArrayList <Integer>();
        
        
        for (int i = one_count + two_count; i < lst.length; i++) {
            if (lst[i] == 2) {
                result.add(i);
                
            }
        }
        for (int i = 0; i < one_count; i++) {
            if (lst[i] == 2) {
                result.add(i);
                
            }
        }
        return result;
    }    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        int num = Integer.parseInt(f.readLine());
        int[] lst = new int [num];
        int[] dup = new int [num]; 
        for (int i = 0; i < num; i++) {
            String line = f.readLine();
            lst[i] = Integer.parseInt(line);
            dup[i] = Integer.parseInt(line);
        }
        int[] ones = new int[lst.length];
        int[] twos = new int[lst.length];
        int[] threes = new int[lst.length];
        int counter = 0;
        int one_count = 0;
        int two_count = 0;
        for (int i = 0; i < lst.length; i++) {
            if (lst[i] == 1) {
                one_count++;
            }
            if (lst[i] == 2) {
                two_count++;
            }
        }
        
         ArrayList <Integer> a = ones(lst, one_count);
         
         for (int i = 0; i < one_count; i++) {
         if (lst[i] != 1) {
         swap(i, a.get(0), lst);
         a.remove(a.get(0));
         counter++;
         
         }
         }
         ArrayList <Integer> b = twos(lst, one_count, two_count);
         
         for (int i = one_count; i < one_count + two_count; i++) {
         if (lst[i] != 2) {
         swap(i, b.get(0), lst);
         
         b.remove(b.get(0));
         counter++;
         }            
         }
         
        int dup_counter = 0;
        ArrayList <Integer> dup_a = dup_threes(dup, one_count, two_count);
        
        for (int i = dup.length - 1; i >= one_count + two_count; i--) {
            if (dup[i] == 1) {
                swap(i, dup_a.get(0), dup);
                dup_a.remove(dup_a.get(0));
                dup_counter++;
                //print(lst);
            }
        }
        for (int i = dup.length - 1; i >= one_count + two_count; i--) {
            if (dup[i] == 2) {
                swap(i, dup_a.get(0), dup);
                dup_a.remove(dup_a.get(0));
                dup_counter++;
                //print(lst);
            }
        }        
        ArrayList <Integer> dup_b = dup_twos(dup, one_count, two_count);
        
        for (int i = one_count + two_count - 1; i >= one_count; i--) {
            if (dup[i] != 2) {
                swap(i, dup_b.get(0), dup);
                //print(dup);
                dup_b.remove(dup_b.get(0));
                dup_counter++;
            }            
        } 
        
        
        out.println(Math.min(counter, dup_counter));
        out.close();
        
    }
} 