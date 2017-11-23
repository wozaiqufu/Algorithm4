public class Counter implements Comparable<Counter>
{
    private final String m_name;
    private int m_count;

    public Counter(String id)
    {
        m_name = id;
    }

    public void increment()
    {
        m_count++;
    }

    public int tally()
    {
        return m_count;
    }

    public String toString()
    {
        return m_count + "  " + m_name;
    }

    public int compareTo(Counter that)
    {
        if(this.m_count < that.m_count)         return -1;
        else if(this.m_count > that.m_count)    return +1;
        else                                    return  0;
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        int trial = Integer.parseInt(args[1]);
        //create n counters
        Counter[] hits = new Counter[n];
        for(int i=0;i<n;i++)
        {
            hits[i] = new Counter("Counter" + i);
        }

        for(int i=0;i<trial;i++)
        {
            hits[StdRandom.uniform(n)].increment();
        }
        //print result
        for(int i=0;i<n;i++) {
            StdOut.println(hits[i]);
        }
    }
}
