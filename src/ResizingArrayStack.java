import java.util.Iterator;

public class ResizingArrayStack <Item> implements Iterable <Item> {
    private Item[] a = (Item[]) new Object [1];
    private int N = 0;
    public boolean isEmpty() {
        return N == 0;
    }
    public int size() {
        return N;
    }
    private void resize (int max) {
        Item[] temp = (Item[]) new Object [max];
        for (int i = 0; i < size(); i++) {
            temp[i] = a[i];
        }
    }
    public void push(Item item) {
        resize(N + 1);
        a[++N] = item;
    }
    public Item pop() {
        Item item = a[--N];
        a[N] = null;
        if (N > 0 && N == size() / 4) {
            resize(size() / 2);
        }
        return item;
    }
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }
}