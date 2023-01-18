import java.util.Arrays;

public class SortPosNeg
{

    public static void main( String args[] )
    {

        int[] array = { 2, 1, -2, 0, -4, -3, 1, -5 };

        sort( array );
        System.out.println( Arrays.toString( array));

    }

    public static void sort( int[] array )
    {
        int l = array.length - 1;
        int s = 0;

        while( s < l )
            if( array[s] < 0 )
            {
                s++;
            }
            else
            {
                //swap s with l

                int temp = array[s];
                array[s] = array[l];
                array[l] = temp;
                l--;
            }
    }
}
