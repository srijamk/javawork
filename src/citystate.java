import java.io.*;
import java.util.*;
import java.util.ArrayList;

class citystate {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("citystate.out")));
        int N = Integer.parseInt(f.readLine());
        ArrayList <String> states = new ArrayList <String>();
        ArrayList <String> cities = new ArrayList <String>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            String [] line = f.readLine().split(" ");
            if (!states.contains(line[1])) {
                cities.add(line[0].substring(0, 2));
                states.add(line[1]);
            }
        }
        
        for (int city = 0; city < cities.size(); city++) {
            if (states.indexOf(cities.get(city)) == cities.indexOf(states.get(city)) && states.indexOf(cities.get(city)) != -1) {
                System.out.println(cities.get(city));
                count++;
            }
        }
        System.out.println(count / 2);
        out.close();
    }
}