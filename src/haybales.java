import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
class haybales {

    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("haybales.out")));
        String [] first_line = f.readLine().split(" ");
        int num_haybales = Integer.parseInt(first_line[0]);
        int num_queries = Integer.parseInt(first_line[1]);
        String [] road = f.readLine().split(" ");
        for (int i = 0; i < num_queries; i++) {
            int count = 0;
            String [] query = f.readLine().split(" ");
            for (int index = 0; index < road.length; index++) {
                if (Integer.parseInt(road[index]) >= Integer.parseInt(query[0]) && Integer.parseInt(road[index]) <= Integer.parseInt(query[1])) {
                    count++;
                }
            }
            out.println(count);
        }
        
        
        out.close();
    }
}
