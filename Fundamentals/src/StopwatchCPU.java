import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class StopwatchCPU
{
    private static final double NANOSECONDS_PER_SECOND = 1000000000;
    private final ThreadMXBean m_threadTimer;
    private final long m_start;

    public StopwatchCPU()
    {
        m_threadTimer = ManagementFactory.getThreadMXBean();
        m_start = m_threadTimer.getCurrentThreadCpuTime();
    }

    public double elapsedTime()
    {
        long now = m_threadTimer.getCurrentThreadCpuTime();
        return (now - m_start)/NANOSECONDS_PER_SECOND;
    }

    public static void main(String[] args)
    {
        int n = Integer.parseInt(args[0]);
        //sum of square root of integers from 1 to n using Math.sqrt(x)
        StopwatchCPU timer1 = new StopwatchCPU();
        double sum = 0.0;
        for(int i=1;i<=n;i++)
        {
            sum += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)",sum,time1);

        //sum of square root of integers from 1 to n using Math.pow(x,0.5)
        StopwatchCPU timer2 = new StopwatchCPU();
        double sum2 = 0.0;
        for(int i=1;i<=n;i++)
        {
            sum2 += Math.pow(0.5,i);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)",sum2,time2);



    }


}
