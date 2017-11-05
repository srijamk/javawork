import java.io.*;
import java.util.*;
import java.util.ArrayList;

class marathon {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("marathon.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("marathon.out")));
        int N = Integer.parseInt(f.readLine());
        int min = Integer.MAX_VALUE;
        int [] x_list = new int [N];
        int [] y_list = new int [N];
        for (int i = 0; i < N; i++) {
            String [] line = f.readLine().split(" ");
            x_list[i] = Integer.parseInt(line[0]);
            y_list[i] = Integer.parseInt(line[1]);
        }
        for (int skip = 1; skip < N - 1; skip++) {
            int distance = 0;
            int l = 0;
            while (l < N - 1) {
                if (l + 1 == skip) {
                    distance += Math.abs(x_list[l + 2] - x_list[l]) + Math.abs(y_list[l + 2] - y_list[l]);
                    l += 2;
                } else {
                    distance += Math.abs(x_list[l + 1] - x_list[l]) + Math.abs(y_list[l + 1] - y_list[l]);
                    l++;
                }
            }
            if (distance < min) {
                min = distance;
            }
    }
    out.println(min);
    out.close();
}
}