import java.util.ArrayList;
import java.util.List;

public class IntersectionTwoSortedArray
{

    public static void main(String args[])
    {
        int[] arr1 = {2,2,3,7,8,11};
        int[] arr2 = {2,5,7,8,9,23,44,53};

        List result =  intersect( arr1, arr2);
        System.out.println("value of mereged array =" + result.toString());

    }

    public static ArrayList intersect( int[] arr1, int[] arr2)
    {
        int m = 0;
        int n = 0;

        List result = new ArrayList();


        while(m <arr1.length-1 && n <arr2.length-1 )
        {
            if( arr1[m] == arr2[n] )
            {
                if( result.size() > 0 && (Integer)result.get( result.size() - 1 ) != arr1[m] )
                {
                    result.add( arr1[m] );
                }
                else if( result.size() == 0 )
                {
                    result.add( arr1[m] );
                }

                m++;
                n++;

            }
            else if( arr1[m] < arr2[n] )
            {
                m++;
            }
            else
            {
                n++;
            }
        }




                return (ArrayList)result;
    }




    }
