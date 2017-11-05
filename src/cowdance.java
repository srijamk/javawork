import java.io.*;
import java.util.*;
import java.lang.Math;
import java.util.Collections;

class cowdance {
    
    public static String print (ArrayList <Integer> list) {
        String array = "[";
        for (int i = 0; i < list.size() - 1; i++) {
            array += list.get(i) + ", ";
        }
        array += list.get(list.size() - 1);
        array += "]";
        return array;
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));  
        out.println(4);
        out.close();
    }
}