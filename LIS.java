//Longest Increasing SubSequence

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS
{

    public static void main( String args[] )
    {
    int[] arr = { 8, 6, 5, 11, 7, 13 };

    int count = LIS.lis( arr );

    System.out.println("value of LIS =" + count);
    }


 private static int lis(int[] arr)
 {

     int[] lisArray ={1,1,1,1,1,1};
     int maxCount = 1;
     for(int i=1;i<arr.length;i++)
     {
         for(int j=0;j<i;j++)
         {

             if(arr[i] > arr[j] && lisArray[i]<= lisArray[j])
             {
                 lisArray[i] = lisArray[j] +1;

                 if(maxCount < lisArray[i]){
                     maxCount = lisArray[i];
                 }
             }

         }

     }

     return maxCount;
 }
}
