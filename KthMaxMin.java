public class KthMaxMin
{

    public static void main(String args[])
    {

        int[] array = {2,5,3,9,8,7,1,6};
        int index =4;
        int n = array.length;

        int KthMin= findNthMin(array,0,n-1,index);

        System.out.println("KthMin = "+ KthMin);

    }

    public static int findNthMin(int[] array, int start, int end, int k)
    {
         int pos =0;
        if(k > 0 && k <= end - start + 1)
        {
           pos= partioning(array,start,end);


        if(pos-start == k-1){
            return array[pos];
        }

        if(pos-start > k-1)
        {
           return findNthMin(array,start,pos-1,k);
        }
        if(pos-start < k-1)
        {
           return findNthMin( array,pos+1,end,k-pos+start-1 );
        }
        }
        return pos;
    }

    public static int partioning( int[] arr, int low, int high)
    {

        int pivot = arr[low];
        int i= 0, j= high;

        while(i<j)
        {

            while(arr[i] <pivot)
            {
                i++;
            }
            while(arr[j] > pivot)
            {
                j--;
            }
            if(i<j)
            {
                //swap arr[i] with arr[j]

                int temp = arr[j];
                arr[j]= arr[i];
                arr[i] = temp;


                i++;
                j--;
            }
        }

        return i;
    }
}
