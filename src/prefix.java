/*
 ID: srijamk1
 LANG: JAVA
 PROG: prefix
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;


class prefix {
    
    private static String sequence = "";
    
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        String a = f.readLine();
        
        ArrayList <String> primitives = new ArrayList <String> ();
        
        
        String[] primitive = a.split(" ");
        for (int i = 0; i < primitive.length; i++) {
            primitives.add(primitive[i]);
        }
        while (!a.equals(".")) {
            a = f.readLine();
            if (!a.equals(".")) {
                primitive = a.split(" ");
                for (int i = 0; i < primitive.length; i++) {
                    primitives.add(primitive[i]);
                }
            }
        }
        int max = 0;
        Collections.sort(primitives);
        String place = f.readLine();
        
        while (place != null) {
            sequence += place;
            place = f.readLine();
        }
        
        ArrayList <ArrayList <Integer>> magic = new ArrayList <ArrayList <Integer>>();
        for (int prim = 0; prim < primitives.size(); prim++) {
            magic.add(new ArrayList <Integer>());
            String primitive_in_question = primitives.get(prim);
            for (int i = 0; i < sequence.length(); i++) {
                String sub_in_question = sequence.substring(0, i + 1);
                if (prim == 0 && i == 0) {
                    if (primitive_in_question.equals(sub_in_question)) {
                        magic.get(prim).add(1);
                        max = Math.max(max, i + 1);
                    } else {
                        magic.get(prim).add(0);
                    }
                }  else if (prim == 0 && i > 0) {
                    magic.get(prim).add(0);
                    
                } else if (prim > 0) {
                    boolean must_continue = true;
                    if (primitive_in_question.equals(sub_in_question)) {
                        magic.get(prim).add(1);
                        max = Math.max(max, i + 1);
                    } else if (magic.get(prim - 1).get(i) == 1) {
                        magic.get(prim).add(1);
                        max = Math.max(max, i + 1);
                    } else {
                        if (sub_in_question.length() > 3) {
                            for (int s = sub_in_question.length() - 1; s > sub_in_question.length() - 3; s--) {
                                String need_to_check = sub_in_question.substring(s);
                                
                                if (magic.get(prim).get(s - 1) == 1 && primitives.contains(need_to_check)) {
                                    magic.get(prim).add(1);
                                    max = Math.max(max, i + 1);
                                    must_continue = false;
                                    break;
                                    
                                }
                            }
                        }
                        if (must_continue && magic.get(prim - 1).get(i) == 0) {
                            magic.get(prim).add(0);
                        }
                        
                    }
                } 
                //magic.get(prim).add(0);
            }
        }
        
        boolean has_all = true;
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < alphabet.length(); i++) {
            if (!primitives.contains("" + alphabet.charAt(i))) {
                has_all = false;
                out.println(max);
                break;
            }
        }
        if (has_all) {
            out.println(1000);
        }
        
        out.close();
        
    }
} 
