/**
 * uses a one-pass algorithm that is less susceptible to
 * floating-point roundoff error than the more straightforward
 * implementation based on saving the sum of the squares of numbers
 * https://en.wikipedia.org/wiki/Algorithms_for_calculating_variance#Online_algorithm
 */
public class Accumulator
{
    private int m_n = 0;//number of data value
    private double m_M2 = 0.0;//sample variance * (n-1)
    private double m_sampVar = 0.0;//sample variance
    private double m_mean = 0.0;//sample mean

    public Accumulator(){}

    public void addDataValue(double x)
    {
        if(Double.isInfinite(x))
        {
            throw new RuntimeException("Param of Accumulator.addDataValue must be finite!");
        }
        m_n++;
        double delta = x - m_mean;
        m_mean += delta/m_n;
        double delta2 = x - m_mean;//
        m_M2 += delta * delta2;
        if(m_n<2) return;
        else    m_sampVar = m_M2/(m_n-1);
    }

    public double mean()
    {
        return m_mean;
    }

    public double var()
    {
        return m_sampVar;
    }

    public double stddev()
    {
        return Math.sqrt(this.var());
    }

    public int count()
    {
        return m_n;
    }

    public static void main(String[] args)
    {
        Accumulator stats = new Accumulator();
        while(!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            stats.addDataValue(x);
            StdOut.printf("n        =%d\n", stats.count());
            StdOut.printf("mean     =%.5f\n", stats.mean());
            StdOut.printf("var      =%.5f\n", stats.var());
            StdOut.printf("stddev   =%.5f\n", stats.stddev());
        }
    }
}
