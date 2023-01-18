public class MinJump
{

    public static void main(String args[])
    {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

        int result =  MinJumpToReach( arr,0, arr.length-1);
        System.out.println("Min. Jump to reach end =" + result);

    }

    public static int MinJumpToReach(int[] arr,int l, int h)
    {
        int min = Integer.MAX_VALUE;
        if(l == h)
        {
            return 0;
        }

        if(arr[l] ==0 )
        {
            return Integer.MAX_VALUE;
        }

        for(int i= l+1; i<= h && i<= l+arr[l];i++ )
        {
            int jumps = MinJumpToReach(arr,i,h);
           // min = Math.min(min,jumps+1);
            if( jumps != Integer.MAX_VALUE && jumps + 1 < min )
                min = jumps + 1;
        }

        return min;

    }
}
