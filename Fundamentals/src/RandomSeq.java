public class RandomSeq
{
    private RandomSeq() {}

    public static void main(String[] args)
    {
        StdOut.print("Please enter 3 params:length,low,high\n");
        int length = StdIn.readInt();
        double low = StdIn.readDouble();
        double high = StdIn.readDouble();

        if(length<1)
        {
            throw new RuntimeException("length must larger than 1");
        }
        for(int i=0;i<length;i++)
        {
            double x = StdRandom.uniform(low,high);
            StdOut.printf("%.3f\n",x);
        }
    }
}
