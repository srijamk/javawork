import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Collections;

class cowcode {
    
    public static String format (ArrayList <String> word) {
        ArrayList <S>
        return word.charAt(word.length() - 1) + word.substring(0, word.length() - 1);
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));  
        String [] list = f.readLine().split(" ");
        String w = list[0];
        ArrayList <String> word = new ArrayList <String>();
        for (int i = 0; i < w.length(); i++) {
            w.add(word.charAt(i) + "");
        }
        long n = Integer.parseInt(list[1]);
        while (word.size() < n) {
            actual_word = format(word);
            n -= word.length();
            word = word + format(word);
        }
        actual_word = format(word);
        n -= len;
        out.println(actual_word.charAt((int)n - 1));
        out.close();
    }
}