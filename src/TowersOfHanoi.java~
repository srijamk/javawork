import java.io.*;
import java.util.*;

class TowersOfHanoi {
    public static void move (char s, char d, char e, int n) {
        if (n <= 0) {
            return;
        }
        move(s, e, d, n - 1);
        System.out.println("Move Disk " + n + " " + "from " + s + " to " + d);
        move(e, d, s, n - 1);
    }
    public static void main (String [] args) {
        move('s', 'd', 'e', 2);
    }
}

