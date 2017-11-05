/*
ID: srijamk1
LANG: JAVA
PROG: friday
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class friday {
    public static boolean is_leap (int year) {
        return (year % 100 == 0 && year % 400 == 0) || (year % 100 != 0 && year % 4 == 0);
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        ArrayList <Integer> friday_counts = new ArrayList <Integer>();
        ArrayList <Integer> month_days = new ArrayList <Integer>();
        int num_years = Integer.parseInt(f.readLine());
;        int day = 0;
        month_days.add(31);
        month_days.add(28);
        month_days.add(31);
        month_days.add(30);
        month_days.add(31);
        month_days.add(30);
        month_days.add(31);
        month_days.add(31);
        month_days.add(30);
        month_days.add(31);
        month_days.add(30);
        month_days.add(31);
        friday_counts.add(0);
        friday_counts.add(0);
        friday_counts.add(0);
        friday_counts.add(0);
        friday_counts.add(0);
        friday_counts.add(0);
        friday_counts.add(0);
        for (int year = 1900; year < 1900 + num_years; year++) {
            if(is_leap(year)) {
                month_days.set(1, 29);
            } else {
                month_days.set(1, 28);
            }            
            for (int i = 0; i < 12; i++) {
                for (int j = 1; j <= month_days.get(i); j++) {

                    day++;
                    if (j == 13) {
                        friday_counts.set(day % 7, friday_counts.get(day % 7) + 1);
                    }
                }
            }
        }
        out.print(friday_counts.get(6) + " ");
        for (day = 0; day <= 4; day++) {
            out.print(friday_counts.get(day) + " ");
        }
        out.print(friday_counts.get(5) + "\n");
        out.close();
    }
}