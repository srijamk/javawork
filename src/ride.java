/*
ID: srijamk1
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("ride.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        String comet = f.readLine();
        String group = f.readLine();
        int comet_product = 1;
        int group_product = 1;
        for (int i = 0; i < comet.length(); i++) {
            comet_product *= (comet.charAt(i) - 'A' + 1);
        }
        for (int j = 0; j < group.length(); j++) {
            group_product *= (group.charAt(j) - 'A' + 1);
        }
        if ((comet_product % 47) == (group_product % 47)) {
            out.println("GO");
        } else {
            out.println("STAY");
        }
        out.close();
    }
}