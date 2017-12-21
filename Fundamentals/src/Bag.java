import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item>
{
    private Node<Item> m_first;
    private int m_n;

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public Bag() {
        m_first = null;
        m_n = 0;
    }

    public boolean IsEmpty() {
        return m_first == null;
    }

    public int size() {
        return m_n;
    }

    public void add(Item item) {
        Node<Item> oldfirst = m_first;
        m_first = new Node<Item>();
        m_first.item = item;
        m_first.next = oldfirst;
        m_n++;
    }

    public Iterator<Item> iterator() {
        return new ListIterator<Item>(m_first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args)
    {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            bag.add(item);
        }
        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) StdOut.println(s);
    }
}


