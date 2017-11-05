/*
ID: srijamk1
LANG: JAVA
PROG: crypt1
*/
import java.io.*;
import java.util.*;
import java.util.ArrayList;
class crypt1 {

    public static boolean is_valid (ArrayList <String> list, String numbers) {
        for (int c = 0; c < numbers.length(); c++) {
            if (!list.contains("" + numbers.charAt(c))) {
                return false;
            }
        }
        return true;
    }
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int num = Integer.parseInt(f.readLine());
        String numbers = f.readLine();
        ArrayList <String> list = new ArrayList <String>();
        for (int i = 0; i < num; i++) {
            list.add("" + numbers.charAt(0));
            if (numbers.length() > 1) {
                numbers = numbers.substring(2);
            }
        }
        String first_num = "";
        String second_num = "";
        int first_partial = 0;
        int second_partial = 0;
        int count = 0;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    
                    first_num = list.get(i) + list.get(j) + list.get(k);
                    for (int a = 0; a < num; a++) {
                        for (int b = 0; b < num; b++) {
                            second_num = list.get(a) + list.get(b);
                            //System.out.println(second_num);
                            first_partial = Integer.parseInt(first_num) * Integer.parseInt("" + second_num.charAt(1));
                            second_partial = Integer.parseInt(first_num) * Integer.parseInt("" + second_num.charAt(0));
                            String final_product = "" + (first_partial + 10 * second_partial);
                            
                            if ((("" + first_partial).length() == 3) && (("" + second_partial).length() == 3) && is_valid(list, final_product + first_num + second_num + ("" + first_partial) + ("" + second_partial))) {
                                count++;
                            }
                        }
                    }

                }
            }        
        }
        out.println(count);
        out.close();
    }

}