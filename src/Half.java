import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class Half{
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        String line = f.readLine();
        if (line != null && Integer.parseInt(line) != 42) {
            while(!(line.equals("42"))) {
                System.out.println(line);
                line = f.readLine();
            }
            f.close();  
        }
    }
}
