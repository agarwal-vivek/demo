import java.util.List;

public class largestSumSubArray
{
    public static void main(String args[])
    {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int result =  largestSum( arr);
        System.out.println("Largest sum of subArray =" + result);

    }

    public static int largestSum(int[] array)
    {

        int prev_sum=0,sum=0;

        for(int i=0; i< array.length-1; i++)
        {
            prev_sum = prev_sum + array[i];

            if(prev_sum> sum)
            {
                sum = prev_sum;
            }
            if(prev_sum <0)
            {
                prev_sum =0;
            }

        }


        return sum;
    }
}
