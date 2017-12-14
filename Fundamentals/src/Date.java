/******************************************************************************
 *  Compilation:  javac Date.java
 *  Execution:    java Date
 *  Dependencies: StdOut.java
 *
 *  An immutable data type for dates.
 *
 ******************************************************************************/
import java.util.Comparator;
public class Date implements Comparable<Date>
{
    private static final int[] DAYS = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    private final int m_year;
    private final int m_month;
    private final int m_day;

    public Date(int month,int day,int year)
    {
        if(!isValid(month,day,year))
        throw new IllegalArgumentException("Invalid Date");
        m_month = month;
        m_day = day;
        m_year = year;
    }
/**
* initialize new date specified as a String in form of MM/DD/YY.
 * */
    public Date(String date)
    {
        String[] fields = date.split("/");
        if(fields.length!=3)
            throw new RuntimeException("Invalid date");
        m_month = Integer.parseInt(fields[0]);
        m_day = Integer.parseInt(fields[1]);
        m_year = Integer.parseInt(fields[2]);
        if(!isValid(m_month,m_day,m_year)) throw new IllegalArgumentException("Invalid date");
    }

    public int month()
    {
        return m_month;
    }

    public int year()
    {
        return m_year;
    }

    public int day()
    {
        return m_day;
    }

    private static boolean isValid(int m,int d,int y)
    {
        if(m < 1 || m > 12)                     return false;
        if(d < 1 || d > DAYS[m])                return false;
        if(m == 2 && d == 29 && !isLeapYear(y)) return false;
        return true;
    }

    private static boolean isLeapYear(int y)
    {
        if(y % 400 == 0) return true;
        if(y % 100 == 0) return false;
        return y % 4 == 0;
    }

    public Date next()
    {
        if(isValid(m_month,m_day + 1,m_year)) return new Date(m_month,m_day + 1,m_year);
        else if(isValid(m_month +1,1,m_year)) return new Date(m_month +1,1,m_year);
        else return new Date(1,1,m_year +1);
    }

    public boolean isAfter(Date that)
    {
        return compareTo(that) > 0;
    }

    public boolean isBefore(Date that)
    {
        return compareTo(that) < 0;
    }

    public int compareTo(Date that)
    {
        if(this.m_year < that.m_year)   return -1;
        if(this.m_year > that.m_year)   return  1;
        if(this.m_month < that.m_month) return -1;
        if(this.m_month > that.m_month) return  1;
        if(this.m_day < that.m_day)     return -1;
        if(this.m_day > that.m_day)     return  1;
        return 0;
    }

    public String toString()
    {
        return m_month +"/" + m_day + "/" + m_year;
    }

    public boolean equals(Object other)
    {
        if(other == this)                       return true;
        if(other == null)                       return false;
        if(other.getClass() != this.getClass()) return false;
        Date that = (Date) other;
        return (that.m_year == this.m_year)&&(that.m_month == this.m_month)&&(that.m_day == this.m_day);
    }

    public int hashCode()
    {
        int hash = 17;
        hash = 31*hash + m_month;
        hash = 31*hash + m_day;
        hash = 31*hash + m_year;
        return hash;
    }

    public static void main(String[] args)
    {
        Date today = new Date(11,14,2017);
        StdOut.println(today);

        for(int i=0;i<5;i++)
        {
            today = today.next();
            StdOut.println(today);
        }

        StdOut.println(today.isAfter(today.next()));
        StdOut.println(today.isBefore(today.next()));

        Date birthday = new Date(8,30,2010);
        for(int j=0;j<10;j++)
        {
            birthday = birthday.next();
            StdOut.println(birthday);
        }


    }
}


