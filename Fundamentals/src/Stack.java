import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>
{
    private Node<Item> m_first;
    private int m_n;
    
    private static class Node<Item>
    {
        private Item item;
        private Node<Item> next;
    }
    public Stack()
    {
        m_first = null;
        m_n = 0;
    }
    
    public boolean isEmpty()
    {
        return m_first==null;
    }
    
    public int size()
    {
        return m_n;
    }
    
    public void push(Item item)
    {
        Node<Item> oldfirst = m_first;
        m_first = new Node<Item>();
        m_first.item = item;
        m_first.next = oldfirst;
        m_n++;
    }
    
    public Item pop()
    {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = m_first.item;
        m_first = m_first.next;
        m_n--;
        return item;
    }
    
    public Item peek()
    {
        if(isEmpty()) throw new NoSuchElementException("Stack underflow");
        return m_first.item;
    }
    
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(Item item:this) 
        {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    
    public Iterator<Item> iterator()
    {
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
          Stack<String> stack = new Stack<String>();
          while(!StdIn.isEmpty())
          {
              String item = StdIn.readString();
              if(!item.equals("-"))
                  stack.push(item);
              else if(stack.isEmpty())
                  StdOut.print(stack.pop() + " ");
          }
          StdOut.println("(" + stack.size() +"left on stack)");
      }
}