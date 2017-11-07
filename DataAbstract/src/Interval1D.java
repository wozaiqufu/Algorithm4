import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Interval1D {
    private double m_lo;
    private double m_hi;

    public Interval1D(double lo,double hi)
    {
        if(lo>hi)
        {
            double temp = lo;
            lo = hi;
            hi = temp;
        }
        this.m_hi = hi;
        this.m_lo = lo;
    }

    public double length()
    {
        return Math.abs(m_hi- m_lo);
    }

    public boolean contains(double x)
    {
        return (x>m_lo)&&(x<m_hi);
    }

    public boolean intersect(Interval1D that)
    {
        if(this.m_hi<that.m_lo)
        {
            return false;
        }
        else if((this.m_hi>that.m_lo)&&(this.m_lo<that.m_hi))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public String toString()
    {
        return "(" + m_lo + "," + m_hi + ")";
    }

    public static void main(String[] args)
    {
        ArrayList<Interval1D> interval1ds = new ArrayList<>();
        Interval1D interval1d1 = new Interval1D(3,5);
        Interval1D interval1d2 = new Interval1D(4,5);
        Interval1D interval1d3 = new Interval1D(1,5);
        Interval1D interval1d4 = new Interval1D(7,9);
        Interval1D interval1d5 = new Interval1D(1,2);

        interval1ds.add(interval1d1);
        interval1ds.add(interval1d2);
        interval1ds.add(interval1d3);
        interval1ds.add(interval1d4);
        interval1ds.add(interval1d5);

        for(int i=0;i<interval1ds.size();i++)
        {
            for(int j=i+1;j<interval1ds.size();j++)
            {
                Interval1D tempinterval1d1 = interval1ds.get(i);
                Interval1D tempinterval1d2 = interval1ds.get(j);
                if(tempinterval1d1.intersect(tempinterval1d2))
                {
                    System.out.println("intersect:"+tempinterval1d1+" "+ tempinterval1d2);
                }
            }
        }
    }
}
