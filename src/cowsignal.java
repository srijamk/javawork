import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;
class cowsignal {
    
    public static String doub (String line, int rep) {
        String result = "";
        for (int i = 0; i < line.length(); i++) {
            for (int j = 0; j < rep; j++) {
                result += line.charAt(i);
            }
        }
        return result;
    }
    public static void main (String [] args) throws IOException {
        
        BufferedReader f = new BufferedReader(new FileReader("cowsignal.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));  
        String result = "";
        String real = "";
        String [] first = f.readLine().split(" ");
        int rep = Integer.parseInt(first[2]);
        int N = Integer.parseInt(first[0]);
        
        for (int i = 0; i < N; i++) {
            String line = f.readLine();
            for (int j = 0; j < rep; j++) {
                if (i == N - 1 && j == rep - 1) {
                    result += doub(line, rep);
                } else {
                    result += doub(line, rep) + "\n";
                }
            }
        }

        out.println(result);
        out.close();
    }
    
    
}