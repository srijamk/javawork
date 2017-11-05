/*
ID: srijamk1
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class gift1 {
    public static void main (String [] args) throws IOException {
        boolean done = false;
        int left_over = 0;
        BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        List <String> list = new ArrayList <String>();
        String line;
        while ((line = f.readLine()) != null) {
            list.add(line);
        }
        int number_of_friends = Integer.parseInt(list.get(0));
        int number_of_recipients = Integer.parseInt(list.get(number_of_friends + 2).substring(list.get(number_of_friends + 2).indexOf(" ") + 1));
        int[] amounts = new int [number_of_friends]; 
        while (true) {
            left_over = 0;
            number_of_recipients = Integer.parseInt(list.get(number_of_friends + 2).substring(list.get(number_of_friends + 2).indexOf(" ") + 1));
            String gift_giver = list.get(number_of_friends + 1);
            int gift_money = Integer.parseInt(list.get(number_of_friends + 2).substring(0, list.get(number_of_friends + 2).indexOf(" ")));
            if (number_of_recipients != 0) {
                left_over = gift_money % number_of_recipients;
            } else if (number_of_recipients == 0 && list.get(list.size() - 1).equals("0 0")) {
                break;
            }
            
                for (int i = 1; i <= number_of_recipients; i++) {
                    if (number_of_friends + 3 + i == list.size()) {
                        done = true;
                    }
                    amounts[list.indexOf(list.get(number_of_friends + 2 + i)) - 1] += gift_money / number_of_recipients;
                }
            

            amounts[list.indexOf(gift_giver) - 1] -= gift_money;
            
            amounts[list.indexOf(gift_giver) - 1] += left_over;
            if (done == false) {
                number_of_friends += number_of_recipients + 2;
                
            } else {
                break;
            }
        }
    
        for (int i = 0; i < Integer.parseInt(list.get(0)); i++) {
            out.println(list.get(i + 1) + " " + amounts[i]);
        }
        out.close();
    }
}