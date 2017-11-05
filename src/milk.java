/*
ID: srijamk1
LANG: JAVA
PROG: milk
*/
import java.io.*;
import java.util.*;
import java.util.Arrays;
class milk {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("milk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        String [] first_line = f.readLine().split(" ");
        int needed_milk = Integer.parseInt(first_line[0]);
        int farmers = Integer.parseInt(first_line[1]);
        ArrayList <Integer> prices = new ArrayList <Integer>();
        int [] sorted_prices = new int [farmers];
        ArrayList <Integer> amounts = new ArrayList <Integer>();
        int min = Integer.MAX_VALUE;
        f.mark(0);
        for (int i = 0; i < farmers; i++) {
            String [] price_to_amount = f.readLine().split(" ");
            int price = Integer.parseInt(price_to_amount[0]);
            int amount = Integer.parseInt(price_to_amount[1]);
            prices.add(price);
            sorted_prices[i] = price;
            amounts.add(amount);
        }
        Arrays.sort(sorted_prices);
        int milk = 0;
        int price = 0;
        while (milk <= needed_milk) {
            //break;
            for (int i = 0; i < farmers; i++) {
                //System.out.println(amounts.get(prices.indexOf(sorted_prices[i])));
                if (amounts.get(prices.indexOf(sorted_prices[i])) + milk <= needed_milk) {
                    //System.out.println(amounts.get(prices.indexOf(sorted_prices[i])));
                    milk += amounts.get(prices.indexOf(sorted_prices[i]));
                    price += sorted_prices[i] * amounts.get(prices.indexOf(sorted_prices[i]));
                    
                } else {
                    price += (needed_milk - milk) * sorted_prices[i];
                    //System.out.println(needed_milk - milk);
                    //System.out.println((needed_milk - milk) * amounts.get(prices.indexOf(sorted_prices[i])));
                    milk  = needed_milk;
                }
            }
            
            milk++;
        }
        out.println(price);
        out.close();
    }
}