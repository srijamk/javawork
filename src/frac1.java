/*
 ID: srijamk1
 LANG: JAVA
 PROG: frac1
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class frac1 {
    
    public static double convert (String num) {
        double numer = Integer.parseInt(num.substring(0, num.indexOf('/'))) * 1.0;
        double denom = Integer.parseInt(num.substring(num.indexOf('/') + 1, num.length()));
        return numer / denom;
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        int num = Integer.parseInt(f.readLine());
        ArrayList <String> lst = new ArrayList <String>();
        ArrayList <Double> dub = new ArrayList <Double>();
        dub.add(0.0);
        dub.add(1.0);
        
        lst.add("0/1");
        lst.add("1/1");
        int counter = 1;
        for (int i = 1; i < num; i++) {
            for (int j = i + 1; j <= num; j++) {
                String fraction = i + "/" + j;
                
                double conv = convert (fraction);
                if (!dub.contains(conv)) {
                    for (int index = 0; index < dub.size(); index++) {
                        if (conv < dub.get(index)) {
                            dub.add(index, conv);
                            lst.add(index, fraction);
                            break;
                        }
                    }
                    
                    
                }
            }
        }
        for (String s: lst) {
            out.println(s);
        }
        out.close();
    }
}