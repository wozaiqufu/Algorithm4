import java.util.Arrays;

public class BinarySearch
{
    /**
     *This class should not be instantiated.
     */
    private BinarySearch(){}
    public static int indexOf(int[] a,int key)
    {
        int lo = 0;
        int hi = a.length - 1;
        while(lo<=hi)
        {
            int mid = lo + (hi - lo)/2;
            if      (key<a[mid]) hi = mid - 1;
            else if (key>a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static int rank(int key,int[] a)
    {
        return indexOf(a,key);
    }

    public static void main(String [] args)
    {
        //read the integers from file
        In in = new In(args[0]);
        int[] whiteList = in.readAllInts();

        Arrays.sort(whiteList);

        while(!StdIn.isEmpty())
        {
            int key = StdIn.readInt();
            if(BinarySearch.indexOf(whiteList,key)==-1)
                StdOut.println(key);
        }
    }
}
