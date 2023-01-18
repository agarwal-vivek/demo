public class FndMaxMin
{

    public static void main(String args[])
    {

        int[] numArray = {2,3,5,3,6,8,6,1};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i< numArray.length;i++)
        {

            if (numArray[i] < min)
            {
                min = numArray[i];
            }
            if(numArray[i] >max)
            {
                max = numArray[i];
            }

        }

        System.out.println("max =" + max);
        System.out.println("min =" + min);


    }
}
