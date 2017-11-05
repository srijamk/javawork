/*
ID: srijamk1
LANG: JAVA
PROG: wormhole
*/
import java.io.*;
import java.util.*;
import java.lang.Math;
class wormhole {
    public static ArrayList <Integer> y_shift (ArrayList <Integer> y_list) {
        ArrayList <Integer> new_y_list = new ArrayList <Integer>();
        new_y_list.add(y_list.get(y_list.size() - 1));
        for (int i = 0; i < y_list.size() - 1; i++) {
            new_y_list.add(y_list.get(i));
        }        
        return y_list;
    }
    public static ArrayList <Integer> x_shift (ArrayList <Integer> x_list) {
        ArrayList <Integer> new_x_list = new ArrayList <Integer>();
        new_x_list.add(x_list.get(x_list.size() - 1));
        for (int i = 0; i < x_list.size() - 1; i++) {
            new_x_list.add(x_list.get(i));
        }        
        return x_list;
    }
    public static boolean is_cycle (ArrayList <int[]> pairs) {
        for (int[] pair: pairs) {
            if (pair[0] == pair[1]) {
                return true;
            }
        }
        return false;
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList <Integer> y_list = new ArrayList <Integer>();
        ArrayList <Integer> x_list = new ArrayList <Integer>();
        ArrayList <int[]> pairs = new ArrayList <int[]>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String [] split_list = f.readLine().split(" ");
            if (y_list.contains(Integer.parseInt(split_list[1]))) {
                count++;
            } else {
                y_list.add(Integer.parseInt(split_list[1]));
            }
        }

        for (int j = 0; j < N / 2; j++) {
            int [] arr = new int [2];
            arr[0] = y_list.get(j);
            arr[1] = y_list.get(j + 1);
            pairs.add(arr);
            System.out.println(arr[0] + " " + arr[1]);
            arr = new int [2];
        }
        
        out.close();
    }
}
