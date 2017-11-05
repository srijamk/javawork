/*
 ID: srijamk1
 LANG: JAVA
 PROG: milk3
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class milk3 {
    public static int [] limits = new int [3];
    public static ArrayList<Integer> result = new ArrayList<Integer>();
    public static int [] pour (int [] list, int a, int b) {
        int [] result = list.clone();
        int b_amount = list[b];
        result[b] += result[a];
        int b_limit = limits[b];
        if (result[b] > b_limit) {
            result[a] = result[b] - b_limit;
            result[b] = b_limit;
        } else {
            result[a] = 0;
        }
        return result;
    }
    public static boolean contains(Set <int[]> visited, int [] list) {
        for (int [] search: visited) {
            if (Arrays.equals(search, list)) {
                return true;
            }
        }
        return false;
    }

    
    
    public static void magic (int [] list, Set <int[]> visited) {
        if (list[0] == 0) {
            result.add(list[2]);
            visited.add(list);
        }
        
        if (list[0] > 0 && list[1] < limits[1]) {
            if (!contains(visited, pour(list, 0, 1))) {
                int [] new_list = pour(list, 0, 1);
                visited.add(new_list);
                magic (new_list, visited);
            }    
        }
        if (list[0] > 0 && list[2] < limits[2]) {
            if (!contains(visited, pour(list, 0, 2))) {
                int [] new_list = pour(list, 0, 2);
                visited.add(new_list);
                magic (new_list, visited);
            }    
        }
        if (list[1] > 0 && list[0] < limits[0]) {
            if (!contains(visited, pour(list, 1, 0))) {
                int [] new_list = pour(list, 1, 0);
                visited.add(new_list);
                magic (new_list, visited);
            }    
        }
        if (list[1] > 0 && list[2] < limits[2]) {
            if (!contains(visited, pour(list, 1, 2))) {
                int [] new_list = pour(list, 1, 2);
                visited.add(new_list);
                magic (new_list, visited);
            }    
        }
        if (list[2] > 0 && list[0] < limits[0]) {
            if (!contains(visited, pour(list, 2, 0))) {
                int [] new_list = pour(list, 2, 0);
                visited.add(new_list);
                magic (new_list, visited);
            }    
        }        
        if (list[2] > 0 && list[1] < limits[1]) {
            if (!contains(visited, pour(list, 2, 1))) {
                int [] new_list = pour(list, 2, 1);
                visited.add(new_list);
                magic (new_list, visited);
            }    
        }
        
    }
    
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        String[] input = f.readLine().split(" ");
        limits[0] = Integer.parseInt(input[0]);
        limits[1] = Integer.parseInt(input[1]);
        limits[2] = Integer.parseInt(input[2]);
        Set<int[]> visited = new HashSet<int[]>();
        int [] first = {0, 0, limits[2]};
        visited.add(first);
        magic(first, visited);
        Collections.sort(result);
        for (int i = 0; i < result.size() - 1; i++) {
            out.print(result.get(i) + " ");
        }
        out.print(result.get(result.size() - 1));
        out.println();
        out.close();
    }
}

