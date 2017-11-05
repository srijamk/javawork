/*
 ID: srijamk1
 LANG: JAVA
 PROG: preface
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class preface {
    private static HashMap<Integer, String> pred = new HashMap<Integer, String>();
    private static HashMap<Integer, String> bank = new HashMap<Integer, String>();
    private static int one_count = 0;
    private static int five_count = 0;
    private static int ten_count = 0;
    private static int fifty_count = 0;
    private static int hundred_count = 0;
    private static int fivehundred_count = 0;
    private static int thousand_count = 0;    
    private static int size = 0;
    private static String[] dynamic;
    public static void incrementer (String num) {
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == 'I') {
                one_count++;
            }
            if (num.charAt(i) == 'V') {
                five_count++;
            }
            if (num.charAt(i) == 'X') {
                ten_count++;
            }
            if (num.charAt(i) == 'L') {
                fifty_count++;
            }
            if (num.charAt(i) == 'C') {
                hundred_count++;
            }
            if (num.charAt(i) == 'D') {
                fivehundred_count++;
            }
            if (num.charAt(i) == 'M') {
                thousand_count++;
            }
        }
    }
    
    
    public static void main (String [] args) throws IOException {
        Scanner scan = new Scanner(new File("preface.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        size = scan.nextInt();
        pred.put(1, "I");
        pred.put(2, "II");
        pred.put(3, "III");
        bank.put(1, "I");
        bank.put(5, "V");
        bank.put(10, "X");
        bank.put(50, "L");
        bank.put(100, "C");
        bank.put(500, "D");
        bank.put(1000, "M");
        
        int num = 1;
        while (num <= size) {
            if (bank.containsKey(num)) {
                pred.put(num, bank.get(num));
            } else if (bank.containsKey(num + 10) && num > 10 && num <= 90) {
                pred.put(num, "X" + bank.get(num + 10));
            } else if (bank.containsKey(num + 100) && num > 90) {
                pred.put(num, "C" + bank.get(num + 100));
            } else if (num % 10 >= 4 && num >= 14) {
                pred.put(num, pred.get(num - num % 10) + pred.get(num % 10));
            } else if (num % 10 == 0 && !pred.get(num - 10).contains("XXX") && num < 140) {
                pred.put(num, pred.get(num - 10) + "X");
            } else if (num % 10 == 0 && num >= 140 && num % 100 != 0) {
                pred.put(num, pred.get(num - (num % 100)) + pred.get((num % 100)));
            } else if (num % 100 == 0 && num >= 200 && num < 1400 && !pred.get(num - 10).contains("CCC")) {
                pred.put(num, pred.get(num - 100) + "C");
            } else if (num % 100 == 0 && num >= 1400) {
                pred.put(num, "M" + pred.get(num - 1000));
            } else if (bank.containsKey(num + 1) && num <= 9) {
                pred.put(num, "I" + bank.get(num + 1));
            } else if (pred.containsKey(num - 1)) {
                pred.put(num, pred.get(num - 1) + "I");
            } else if (pred.containsKey(num - 2)) {
                pred.put(num, pred.get(num - 2) + "II");
            } else if (pred.containsKey(num - 3)) {
                pred.put(num, pred.get(num - 3) + "III");
                
            } else if (pred.containsKey(num - 100)) {
                pred.put(num, pred.get(num - 100) + "C");
            } else if (pred.containsKey(num - 200)) {
                pred.put(num, pred.get(num - 200) + "CC");
            } else if (pred.containsKey(num - 300)) {
                pred.put(num, pred.get(num - 300) + "CCC");
            }    
             else if (pred.containsKey(num - 1000)) {
                pred.put(num, pred.get(num - 1000) + "M");
            } else if (pred.containsKey(num - 2000)) {
                pred.put(num, pred.get(num - 2000) + "MM");
            } else if (pred.containsKey(num - 3000)) {
                pred.put(num, pred.get(num - 3000) + "MMM");
            }               
            incrementer(pred.get(num));
            System.out.println(pred.get(num));
            num++;
        }
        if (one_count != 0) {
            out.println("I " + one_count);
        }
        if (five_count != 0) {
            out.println("V " + five_count);
        }
        if (ten_count != 0) {
            out.println("X " + ten_count);
        }
        if (fifty_count != 0) {
            out.println("L " + fifty_count);
        }
        if (hundred_count != 0) {
            out.println("C " + hundred_count);
        }
        if (fivehundred_count != 0) {
            out.println("D " + fivehundred_count);
        }
        if (thousand_count != 0) {
            out.println("M " + thousand_count);
        }
        out.close();
    }
}
