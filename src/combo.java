/*
ID: srijamk1
LANG: JAVA
PROG: combo
*/
import java.io.*;
import java.util.*;
import java.lang.Math;
class combo {
    public static boolean is_valid (int first, int second, int third, String[] lock, int max) {
        boolean first_cases = Math.abs(Integer.parseInt(lock[0]) - first) <= 2 || 
            ((Integer.parseInt(lock[0]) == 1 && (first == max || first == max - 1)) || (Integer.parseInt(lock[0]) == 2 && first == max)) ||
            ((first == 1 && (Integer.parseInt(lock[0]) == max || Integer.parseInt(lock[0]) == max - 1)) || (first == 2 && Integer.parseInt(lock[0]) == max));
        boolean second_cases = Math.abs(Integer.parseInt(lock[1]) - second) <= 2 || 
            ((Integer.parseInt(lock[1]) == 1 && (second == max || second == max - 1)) || (Integer.parseInt(lock[1]) == 2 && second == max)) ||
            ((second == 1 && (Integer.parseInt(lock[1]) == max || Integer.parseInt(lock[1]) == max - 1)) || (second == 2 && Integer.parseInt(lock[1]) == max));
        boolean third_cases = Math.abs(Integer.parseInt(lock[2]) - third) <= 2 || 
            ((Integer.parseInt(lock[2]) == 1 && (third == max || third == max - 1)) || (Integer.parseInt(lock[2]) == 2 && third == max)) ||
            ((third == 1 && (Integer.parseInt(lock[2]) == max || Integer.parseInt(lock[2]) == max - 1)) || (third == 2 && Integer.parseInt(lock[2]) == max));
        return first_cases && second_cases && third_cases;
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        int max = Integer.parseInt(f.readLine());
        String [] john = f.readLine().split(" ");
        String [] master = f.readLine().split(" ");
        int count = 0;
        for (int first = 1; first <= max; first++) {
            for (int second = 1; second <= max; second++) {
                for (int third = 1; third <= max; third++) {
                    if (is_valid(first, second, third, john, max) || is_valid(first, second, third, master, max)) {
                        count++;
                    }
                }
            }
        }
        out.println(count);
        out.close();
    }
}