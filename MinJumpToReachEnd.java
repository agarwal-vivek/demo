public class MinJumpToReachEnd
{


    public static void main(String args[])
    {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        int result =  MinJumpToReach( arr,0,arr.length-1);
        System.out.println("Largest sum of subArray =" + result);

    }

    public static int MinJumpToReach(int[] arr,int l, int h)
    {
        // Base case: when source
        // and destination are same
        if( h == l )
            return 0;

        // When nothing is reachable
        // from the given source
        if( arr[l] == 0 )
            return Integer.MAX_VALUE;

        // Traverse through all the points
        // reachable from arr[l]. Recursively
        // get the minimum number of jumps
        // needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for( int i = l + 1; i <= h && i <= l + arr[l]; i++ )
        {
            int jumps = MinJumpToReach( arr, i, h );
            if( jumps != Integer.MAX_VALUE && jumps + 1 < min )
                min = jumps + 1;
        }
        return min;
    }

}
