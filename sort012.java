import java.util.Arrays;

public class sort012
{
    public static void main(String[] args)
    {

        int[] a ={2,1,1,0,2,1,0};

        printSegregateArray(a);

    }

    public static void printSegregateArray(int[] a)
    {
        int start = 0;
        int prev = 0;
        int end = a.length - 1;

        while( start < end )
        {
            if( a[start] == 0 )
            {
                swap( a, start, prev );
                prev++;
                start++;


            }
            if( a[start] == 1 )
            {
                start++;
            }

            if( a[start] == 2 )
            {
                swap( a, start, end );
                // start++;
                end--;
            }

        }
        Arrays.stream( a ).forEach( System.out::println);

    }

    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j]=temp;

    }
}
