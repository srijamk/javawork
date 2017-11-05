import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.lang.Math;
class square {

    public static void main (String [] args) throws IOException {
        
        BufferedReader f = new BufferedReader(new FileReader("square.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("square.out")));  
        String [] first = f.readLine().split(" ");
        String [] second = f.readLine().split(" ");
        // first[0] and first[2] are x
        int min_x = Math.min(Math.min(Math.min(Integer.parseInt(first[0]), Integer.parseInt(second[0])), Integer.parseInt(first[2])), Integer.parseInt(second[2]));
        int max_x = Math.max(Math.max(Math.max(Integer.parseInt(first[0]), Integer.parseInt(second[0])), Integer.parseInt(first[2])), Integer.parseInt(second[2]));
        int min_y = Math.min(Math.min(Math.min(Integer.parseInt(first[1]), Integer.parseInt(second[1])), Integer.parseInt(first[3])), Integer.parseInt(second[3]));
        int max_y = Math.max(Math.max(Math.max(Integer.parseInt(first[1]), Integer.parseInt(second[1])), Integer.parseInt(first[3])), Integer.parseInt(second[3]));
        int x_diff = max_x - min_x;
        int y_diff = max_y - min_y;
        int side = Math.max(x_diff, y_diff);
        out.println(side * side);
        out.close();
    }
}