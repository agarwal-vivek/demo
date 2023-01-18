import java.util.Arrays;
import java.util.List;

public class MergeTwoSortedArrayWithoutExtraSpace
{

    public static void main(String args[])
    {
        int[] arr1 = {3,7,8,11};
        int[] arr2 = {2,4,6,9,10};


        merge( arr1, arr2);
        System.out.println("1st array =" + Arrays.toString(arr1));
        System.out.println("2nd array =" + Arrays.toString(arr2));

    }


    public static void merge(int[] arr1, int[] arr2)
    {
        int l1= arr1.length-1;
        int l2 = arr2.length-1;
        int i =0;
        int j=0;

        while(i <= l1 && j <= l2)
        {
            if( arr1[i] > arr2[j] )
            {
                //swap arr1[i] with arr2[j]

                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i++;
                Arrays.sort( arr2);
            }
            if( i< l1 &&  arr1[i] < arr2[j] )
            {
                j++;
            }
        }

        //sort arr2[j];




    }
}
