import java.io.*;
import java.util.*;

class Test {
    public static String hotPotato (String [] players, int num) {
        Queue<String> q = new Queue<String>();
        for (int i = 0; i < players.length; i++) {
            q.enqueue(players[i]);
        }
        System.out.println(q.dequeue());
        while (q.size() > 1) {
            for (int i = 0; i < num; i++) {
                q.enqueue(q.dequeue());
            }
            q.dequeue();
        }
        return q.dequeue();
        
    }
    
    public static void main (String [] args) {
        String [] players = {"Harry", "Ron", "Hermione", "Draco", "Crabbe", "Goyle"};
        System.out.println(hotPotato(players, 2));
    }
}

class Queue<Item> {
    
    private static int count = 0;
    private Node first;
    
    public class Node {
        Item item;
        Node next;
    }
    public boolean isEmpty () {
        return first == null;
    }
    public void enqueue (Item elem) {
        Node oldfirst = first;
        first = new Node();
        first.item = elem;
        first.next = oldfirst;
        System.out.println(first);
        count++;
    }
    public Item dequeue() {
        Node item = first;
        for (int i = 0; i < count - 1; i++) {
            item = item.next;
        }
        Item remove = item.next.item;
        item.next = null;
        return remove;
    }
    public static int size () {
        return count;
    }

}