public class ReverseArrayRecursion
{

    public static void main(String args[])
    {
        ReverseArrayRecursion rA = new ReverseArrayRecursion();
        int[] numArray = {1,2,3,4,5,6,7,8,9,10};
        int n = numArray.length;
        rA.reverse(numArray,0,n-1);

        for(int j:numArray)
        {
            System.out.println( j +"," );
        }
    }


    public  void reverse(int[] numArray,int start, int end)
    {

        int len = numArray.length;
        if(start >= (len/2) )
        {
            return;
        }

        //Swap start with end element
         int temp = numArray[start];
        numArray[start] = numArray[end];
        numArray[end] = temp;
        reverse(numArray,start+1,end-1);

    }
}
