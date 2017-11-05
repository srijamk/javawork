/*
 ID: srijamk1
 LANG: JAVA
 PROG: ariprog
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;

class ariprog {
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int seq = Integer.parseInt(f.readLine());
        int bound = Integer.parseInt(f.readLine());
        ArrayList <String> results = new ArrayList <String>();
        boolean [] list = new boolean [200000];
        for (int i = 0; i <= bound; i++) {
            for (int j = 0; j <= bound; j++) {
                list[i*i + j*j] = true;
            }
            
        }
        
        boolean none = true;
        for (int inc = 1; inc < 3000; inc++) {
            
            
            for (int i = 0; i < list.length; i++) {
                
                if (list[i]) {
                    int dup = i;
                    
                    boolean worked = true;
                    for (int j = 1; j <= seq; j++) {
                        
                        if (!list[dup]) {
                            
                            worked = false;
                            break;
                        }
                        dup += inc;
                    }
                    if (worked) {
                        none = false;
                        out.println(i + " " + inc);
                    }
                }
            }
            
        }
        if (none) {
            out.println("NONE");
        }
        out.close();
        
    }
}