import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Point2D;
public class Interval2D_uc
{
    public static void main(String[] args)
    {
        double xmin = Double.parseDouble(args[0]);
        double xmax = Double.parseDouble(args[1]);
        double ymin = Double.parseDouble(args[2]);
        double ymax = Double.parseDouble(args[3]);
        int n = Integer.parseInt(args[4]);

        Interval1D xInterval = new Interval1D(xmin,xmax);
        Interval1D yInterval = new Interval1D(ymin,ymax);
        Interval2D box = new Interval2D(xInterval,yInterval);
        box.draw();

        Counter counter = new Counter("hits");
        for(int i=0;i<n;i++)
        {
            double x = StdRandom.uniform(0.0,1.0 );
            double y = StdRandom.uniform(0.0,1.0);
            Point2D point  = new Point2D(x,y);

            if(box.contains(point)) counter.increment();
            else                    point.draw();
        }
        StdOut.println(counter);
        StdOut.printf("box area = %.2f\n",box.area());
    }
}

