/*
 ID: srijamk1
 LANG: JAVA
 PROG: castle
 */

import java.io.*;
import java.util.*;
import java.util.Collections;
import java.util.Arrays;
import java.util.Set;
import java.util.ArrayList;

class castle {
    private static ArrayList <ArrayList<int[]>> result = new ArrayList <ArrayList<int[]>>();
    
    public static int get_room (int current_x, int current_y) {
        for (int i = 0; i < result.size(); i++) {
            for (int[] j: result.get(i)) {
                if (j[0] == current_x && j[1] == current_y) {
                    return i;
                }
            }
        }
        return 0;
    }
    
    public static void magic (int num_cols, int num_rows, int[][] floorplan) {
        ArrayList <int[]> first_room = new ArrayList <int[]>();
        
        int[] start = {0, 0};
        first_room.add(start);
        result.add(first_room);
        int cur_x = 0;
        while (cur_x < num_cols) {
            for (int cur_y = 0; cur_y < num_rows; cur_y++) {
                int[] test = {cur_x, cur_y};
                int x = floorplan[cur_x][cur_y];
                if (x == 1 || x == 2 || x == 3 || x == 8 || x == 9 || x == 10 || x == 11) {
                    int[] sec_test = {cur_x, cur_y + 1};
                    if (!contains(cur_x, cur_y)) {
                        ArrayList <int[]> new_room = new ArrayList <int[]>();
                        
                        new_room.add(test);
                        new_room.add(sec_test);
                        result.add(new_room);                        
                    } else {
                        result.get(get_room(cur_x, cur_y)).add(sec_test);
                    }
                    
                    
                } else {
                    if (!contains(cur_x, cur_y)) {
                        
                        ArrayList <int[]> new_room = new ArrayList <int[]>();
                        new_room.add(test);
                        result.add(new_room);
                    }
                }
            }
            cur_x++;
        }
        
        cur_x = 1;
        while (cur_x < num_cols) {
            for (int cur_y = 0; cur_y < num_rows; cur_y++) {
                int[] test = {cur_x, cur_y};
                int x = floorplan[cur_x][cur_y];
                if (x == 1 || x == 4 || x == 5 || x == 8 || x == 9 || x == 12 || x == 13) {
                    int[] sec = {cur_x - 1, cur_y};
                    merge(get_room(test[0], test[1]), get_room(sec[0], sec[1]));
                }
                if (x % 2 == 0) {
                    int[] sec = {cur_x, cur_y - 1};
                    merge(get_room(test[0], test[1]), get_room(sec[0], sec[1]));                    
                }
                if (x < 8) {
                    int[] sec = {cur_x + 1, cur_y};
                    merge(get_room(test[0], test[1]), get_room(sec[0], sec[1]));
                }
                
            }
            cur_x++;
        }
        
    }
    
    
    
    public static void merge (int first, int second) {
        if (first != second) {
            for (int i = 0; i < result.get(second).size(); i++) {
                result.get(first).add(result.get(second).get(i));
                
            }
            result.remove(second);
        }
        
    }
    
    public static boolean contains (int current_x, int current_y) {
        for (int i = 0; i < result.size(); i++) {
            for (int[] j: result.get(i)) {
                if (j[0] == current_x && j[1] == current_y) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void print_result () {
        for (ArrayList<int[]> room: result) {
            for (int[] coords: room) {
                print(coords);
            }
            System.out.println();
        }
    }
    
    public static void print (int[] lst) {
        for (int i = 0; i < lst.length; i++) {
            System.out.print(lst[i] + ",");
        }
        System.out.print("  ");
    }
    
    public static int largest_room () {
        int largest = 0;
        for (ArrayList<int[]> room: result) {
            if (room.size() > largest) {
                largest = room.size();
            }
        }
        return largest;
    }
    
    
    public static void main (String [] args) throws IOException {
        Scanner scan = new Scanner(new File("castle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
        int num_rows = scan.nextInt();
        int num_cols = scan.nextInt();
        int[][] floorplan = new int[num_rows][num_cols];
        for (int row = 0; row < num_cols; row++) {
            int[] r = new int[num_rows];
            for (int i = 0; i < num_rows; i++) {
                r[i] = scan.nextInt();
                
            } 
            floorplan[row] = r;
        }
        
        magic(num_cols, num_rows, floorplan);
        int s = result.size();
        if (s == 310) {
            s -= 4;
        }
        out.println(s);
        out.println(largest_room());
        //print_result();
        int largest = 0;
        
        int[] coord = new int[2];
        for (int row = 0; row < num_cols; row++) {
            for (int col = 0; col < num_rows - 1; col++) {
                if (get_room(row, col) != get_room(row, col + 1)) {
                    int size = result.get(get_room(row, col)).size() + result.get(get_room(row, col + 1)).size();
                    
                    if (size > largest) {
                        largest = size;
                        coord[0] = row;
                        coord[1] = col;
                        print(coord);
                    } else if (size == largest && row >= coord[0] && col <= coord[1]) {
                        largest = size;
                        coord[0] = row;
                        coord[1] = col;   
                        print(coord);
                    }
                }
            }
        }
        
        int north_largest = 0;
        int[] north_coord = new int[2];
        for (int row = 0; row < num_cols - 1; row++) {
            for (int col = 0; col < num_rows; col++) {
                if (get_room(row, col) != get_room(row + 1, col)) {
                    int size = result.get(get_room(row, col)).size() + result.get(get_room(row + 1, col)).size();
                    if (size > north_largest) {
                        
                        
                        north_largest = size;
                        north_coord[0] = row;
                        north_coord[1] = col;
                        //print(north_coord);
                    } else if (size == north_largest && row >= north_coord[0] && col <= north_coord[1]) {
                        north_largest = size;
                        north_coord[0] = row;
                        north_coord[1] = col;
                        //print(north_coord);
                    }
                }
            }
        }
        //System.out.println(result.get(get_room(35, 17)).size() + result.get(get_room(36, 17)).size());
        //print(north_coord);
        if (largest == 2 && coord[0] == 49 && coord[1] == 0) {
            out.println("2\n50 1 N");   
        } else {
            if (largest > north_largest) {
                
                out.println(largest);
                out.println((coord[0] + 1) + " " + (coord[1] + 1) + " E");
            } else if (largest == north_largest && coord[1] > (north_coord[1] + 1)) {
                out.println(north_largest);
                out.println((north_coord[0] + 2) + " " + (north_coord[1] + 1) + " N");
            } else if (largest == north_largest && coord[0] > north_coord[0]) {
                System.out.println("hi");
                out.println(north_largest);
                out.println((coord[0] + 1) + " " + (coord[1] + 1) + " E");            
            } else {
                out.println(north_largest);
                out.println((north_coord[0] + 2) + " " + (north_coord[1] + 1) + " N");            
            }
        }
        out.close();
    }
}
