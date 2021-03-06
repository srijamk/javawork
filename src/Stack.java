import java.io.*;
import java.util.*;

class Stack<Item> {
    
    private Node first;
    private static int count = 0;
    
    private class Node {
        Item item;
        Node next; 
    }
    
    public static int size() {
        return count;
    }
    
    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }
    
    public void push (Item elem) {
        Node oldfirst = first;
        first = new Node();
        first.item = elem;
        first.next = oldfirst;
        count++;
    }
    
    public Item peek() {
        return first.item;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
}

class Test {

    public static String revstring (String str) {
        Stack<String> s = new Stack<String>();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            s.push("" + str.charAt(i));
        }
        for (int i = 0; i < str.length(); i++) {
            result += s.pop();
        }
        return result;
    }
    
    public static boolean matches (char a, char b) {
        return ((a == '(' && b == ')') || (a == '{' && b == '}') || (a == '[' && b == ']'));
    }
    
    public static boolean balanced (String str) {
        Stack<Character> open = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                open.push(str.charAt(i));
            }
            if (matches(open.peek(), str.charAt(i)) && !open.isEmpty()){
                open.pop();
            }
        }
        return open.isEmpty();
    }
    
    public static String to_base (int num, int base) {
        Stack<String> stack = new Stack<String>();
        String result = "";
        while (num > 0) {
            stack.push("" + (num % base));
            num /= base;
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            result += stack.pop();
        }
        return result;
    }
    
    public static boolean is_operator (String a) {
        return (a.equals("+") || a.equals("-") || a.equals("*") || a.equals("/"));
    }
    public static boolean is_operand (String a) {
        return !(is_operator(a) || a.equals("(") || a.equals(")"));
    }
    public static void infix_to_postfix (String infix) {
        Stack<String> opstack = new Stack<String>();
        ArrayList <String> output = new ArrayList <String>();
        String [] infix_list = infix.split(" ");
        for (int i = 0; i < infix_list.length; i++) {
            if (is_operand(infix_list[i])) {
                output.add(infix_list[i]);
            } else if (infix_list[i].equals("(")) {
                opstack.push("(");
            } else if (infix_list[i].equals(")")) {
                while (!opstack.peek().equals("(")) {
                    if (is_operator(opstack.peek())) {
                        output.add(opstack.peek());
                    }
                    opstack.pop();
                    
                }
                opstack.pop();
            } else {
                opstack.push(infix_list[i]);
            }
        }
        for (String o: output) {
            System.out.print(o + " ");
        }
    }
    
    public static void main (String [] args) {
        infix_to_postfix("1 * 2 + 3 * 4");
    }
}