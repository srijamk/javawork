import java.io.*;
import java.util.*;
import java.util.ArrayList;

class blocks {
    public static int num_instances (char letter, String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                count++;
            }
        }
        return count;
    }

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("blocks.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("blocks.out")));  
        int N = Integer.parseInt(f.readLine());
        int [] amounts = new int [26];
        for (int i = 0; i < N; i++) {
            String [] line = f.readLine().split(" ");
            for (int j = 97; j <= 122; j++) {
                amounts[j - 97] += Math.max(num_instances((char)j, line[0]), num_instances((char)j, line[1])); 
            }
        }
        for (int l = 0; l < 26; l++) {
            out.println(amounts[l]);
        }
        out.close();
    }
}