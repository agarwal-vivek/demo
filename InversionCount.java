import java.util.Arrays;

public class InversionCount
{
    public static void main(String args[])
    {
        int[] arr = {1, 20, 6, 4, 5 };

        int result =  calcluateInversion( arr,0,arr.length-1);
        System.out.println("Total invesion count = " + result);

    }


    public static int merge(int[] arr, int l ,int mid,int r)
    {
        int i=0,j=0,k=l,count=0;
        int[] left = Arrays.copyOfRange(arr,l,mid+1);
        int[] right= Arrays.copyOfRange( arr,mid+1,r+1 );
        //int[] result = new int[r-l];

        while(i<left.length && j<right.length)
        {
            if( left[i] < right[j] )
            {
                arr[k++] = left[i++];
            }
            else
            {
                arr[k++] = right[j++];
                count = count + (mid - i + 1);
            }
        }

        while(i< left.length)
        {
            arr[k++] = left[i++];
        }
        while(j< right.length)
        {
            arr[k++] = right[j++];
        }

        return count;
    }


    public static int calcluateInversion(int[] arr,int l,int r)
    {
        int count=0;

        if(l <r)
        {
            int mid = (l + r) / 2;

            count += calcluateInversion( arr, l, mid );
            count += calcluateInversion( arr, mid + 1, r );
            count += merge( arr, l, mid, r );
        }
     return count;
    }
}
