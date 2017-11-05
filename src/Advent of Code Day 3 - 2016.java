
import java.io.*;
import static java.lang.System.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Math;
import java.util.ArrayList;

class Day_3 {

    public static boolean is_triangle (int first, int second, int third) {
        if (first + second <= third) {
            return false;
        } else if (first + third <= second) {
            return false;
        } else if (second + third <= first) {
            return false;
        }
        return true;
    }
    /*
     * Advent of Code Day 3: Part 1
     public static void main (String [] args) throws IOException {
     System.out.println(is_triangle(5, 20, 25));
     BufferedReader f = new BufferedReader(new FileReader("input_day_3.in"));
     PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("input_day_3.out")));
     int count = 0;
     for (int i = 0; i < 1901; i++) {
     String line = f.readLine().substring(2);
     String [] split_line = line.split("  ");
     String first = split_line[0];
     if (first.charAt(0) == ' ') {
     first = first.substring(1);
     }
     String second = split_line[1];
     if (second.charAt(0) == ' ') {
     second = second.substring(1);
     }
     String third = split_line[2];
     if (third.charAt(0) == ' ') {
     third = third.substring(1);
     }
     if (is_triangle(Integer.parseInt(first), Integer.parseInt(second), Integer.parseInt(third))) {
     count++;
     }
     }
     System.out.println(count);
     }
     */
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("input_day_3.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("input_day_3.out")));
        int count = 0;
        for (int i = 0; i < 634; i++) {
            String first_line = f.readLine().substring(2);
            String second_line = f.readLine().substring(2);
            String third_line = f.readLine().substring(2);
            
            String [] first_split = first_line.split("  ");
            String first_first = first_split[0];
            if (first_first.charAt(0) == ' ') {
                first_first = first_first.substring(1);
            }
            String first_second = first_split[1];
            if (first_second.charAt(0) == ' ') {
                first_second = first_second.substring(1);
            }
            String first_third = first_split[2];
            if (first_third.charAt(0) == ' ') {
                first_third = first_third.substring(1);
            }        
            String [] second_split = second_line.split("  ");
            String second_first = second_split[0];
            if (second_first.charAt(0) == ' ') {
                second_first = second_first.substring(1);
            }
            String second_second = second_split[1];
            if (second_second.charAt(0) == ' ') {
                second_second = second_second.substring(1);
            }
            String second_third = second_split[2];
            if (second_third.charAt(0) == ' ') {
                second_third = second_third.substring(1);
            }    
            String [] third_split = third_line.split("  ");
            String third_first = third_split[0];
            if (third_first.charAt(0) == ' ') {
                third_first = third_first.substring(1);
            }
            String third_second = third_split[1];
            if (third_second.charAt(0) == ' ') {
                third_second = third_second.substring(1);
            }
            String third_third = third_split[2];
            if (third_third.charAt(0) == ' ') {
                third_third = third_third.substring(1);
            }   
            String [] list = {first_first, first_second, first_third, second_first, second_second, second_third, third_first, third_second, third_third};
            if (is_triangle(Integer.parseInt(list[0]), Integer.parseInt(list[3]), Integer.parseInt(list[6]))) {
                count++;
            }
            if (is_triangle(Integer.parseInt(list[1]), Integer.parseInt(list[4]), Integer.parseInt(list[7]))) {
                count++;
            }
            if (is_triangle(Integer.parseInt(list[2]), Integer.parseInt(list[5]), Integer.parseInt(list[8]))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
