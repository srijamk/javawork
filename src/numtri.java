/*
 ID: srijamk1
 LANG: JAVA
 PROG: numtri
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class numtri {
    private static int num_rows;
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        num_rows = Integer.parseInt(f.readLine());
        int [][] a = new int [num_rows][num_rows];
        
        for (int i = 0; i < num_rows; i++) {
            String [] line = f.readLine().split(" ");
            
            for (int j = 0; j < line.length; j++) {
                a[i][j] = Integer.parseInt(line[j]);
                
            }
        } 
        int [][] best = new int [num_rows][num_rows];
        
        int i, j, max;
        // Sets the first value of best to the top leftmost value
        best[0][0] = a[0][0];
        for (i = 1; i < num_rows; i++) {
            // Accumulates values for each row
            best[i][0] = a[i][0] + best[i-1][0];
            for (j = 1; j < num_rows; j++) {
                best[i][j] = a[i][j] + Math.max(best[i-1][j], best[i-1][j-1]);
                best[i][i] = a[i][i] + best[i-1][i-1];
                
            }
        }
        max = best[num_rows - 1][0];
        for (i = 1; i < num_rows; i++) {
            if (best[num_rows - 1][i] >= max) {
                max = best[num_rows - 1][i];
            }
        }
        out.println(max);
        out.close();
    }
}