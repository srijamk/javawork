import java.io.*;
import java.util.*;
import java.util.ArrayList;
class combos {
    public static void main (String [] args) {
        String foods = "ABC";
        String drinks = "DE";
        ArrayList <String> ans = new ArrayList <String>();
        for (int food_char = 0; food_char < drinks.length(); food_char++) {
            System.out.println("" + foods.charAt(food_char) + drinks.charAt(food_char));
        }
    }
}