/******************************************************************************
 *  Compilation:  javac Vector.java
 *  Execution:    java Vector
 *  Dependencies: StdOut.java
 *
 *  Implementation of a vector of real numbers.
 *
 *  This class is implemented to be immutable: once the client program
 *  initialize a Vector, it cannot change any of its fields
 *  (d or data[i]) either directly or indirectly. Immutability is a
 *  very desirable feature of a data type.
 *
 *  % java Vector
 *      x   = 1.0  2.0  3.0  4.0
 *      y   = 5.0  7.0  2.0  4.0
 *      z   = 6.0  9.0  5.0  8.0
 *      10z   = 60.0  90.0  50.0  80.0
 *      |x|      = 5.477225575051661
 *      <x, y>    = 41.0
 *      dist(x, y) = 6.48074069840786
 *      dir(x)     = 0.18257418583505536  0.3651483716701107  0.5477225575051661  0.7302967433402214
 *  Note that Vector is also the name of an unrelated Java library class
 *  in the package java.util.
 *
 ******************************************************************************/
public class Vector
{
    private int m_d;
    private double[] m_data;

    public Vector(int d)
    {
        this.m_d = d;
        this.m_data = new double[d];
    }

    public Vector(double... a )
    {
        this.m_d = a.length;
        this.m_data = new double[m_d];
        for(int i=0;i<m_d;i++)
        {
            m_data[i] = a[i];
        }
    }

    public int length()
    {
        return m_d;
    }

    public int dimension()
    {
        return m_d;
    }

    public double dot(Vector that)
    {
        if(this.m_d != that.m_d) throw new IllegalArgumentException("Dimensions don't agree!");
        double sum = 0.0;
        for(int i=0;i<m_d;i++)
        {
            sum += this.m_data[i] * that.m_data[i];
        }
        return sum;
    }

    public double magnitude()
    {
        return Math.sqrt(this.dot(this));
    }

    public Vector plus(Vector that)
    {
        if(that.m_d != this.m_d) throw new IllegalArgumentException("Dimensions don't agree!");
        Vector p = new Vector(m_d);
        for(int i=0;i<m_d;i++)
        {
            p.m_data[i] = this.m_data[i] + that.m_data[i];
        }
        return p;
    }

    public Vector minus(Vector that)
    {
        if(that.m_d != this.m_d) throw new IllegalArgumentException("Dimensions don't agree!");
        Vector p = new Vector(m_d);
        for(int i=0;i<m_d;i++)
        {
            p.m_data[i] = this.m_data[i] - that.m_data[i];
        }
        return p;
    }

    public double distanceTo(Vector that)
    {
        if(that.m_d != this.m_d) throw new IllegalArgumentException("Dimensions don't agree!");
        return this.minus(that).magnitude();
    }
    public double cartesian(int i)
    {
        return m_data[i];
    }

    /**
     * Returns the scalar-vector product of this vector and the specified scalar
     *
     * @param  alpha the scalar
     * @return the vector whose value is {@code (alpha * this)}
     */
    public Vector scale(double alpha)
    {
        Vector s = new Vector(m_d);
        for(int i=0;i<m_d;i++)
        {
            s.m_data[i] = alpha * m_data[i];
        }
        return s;
    }
    /**
     * Returns a unit vector in the direction of this vector.
     *
     * @return a unit vector in the direction of this vector
     * @throws ArithmeticException if this vector is the zero vector
     */
    public Vector direction()
    {
        if(this.magnitude()==0) throw new ArithmeticException("Zero-vector has no direction");
        return this.scale(1 / this.magnitude());
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for(int i=0;i<m_d;i++)
        {
            s.append(m_data[i] + "  ");
        }
        return s.toString();
    }

    public static void main(String[] args)
    {
        double[] xdata = {1.0,2.0,3.0,4.0};
        double[] ydata = {5.0,7.0,2.0,4.0};

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        StdOut.println("x   = " + x);
        StdOut.println("y   = " + y);

        Vector z = x.plus(y);
        StdOut.println("z   = " + z);

        z = z.scale(10.0);
        StdOut.println("10z   = " + z);

        StdOut.println("  |x|      = " + x.magnitude());
        StdOut.println(" <x, y>    = " + x.dot(y));
        StdOut.println("dist(x, y) = " + x.distanceTo(y));
        StdOut.println("dir(x)     = " + x.direction());
    }
}
