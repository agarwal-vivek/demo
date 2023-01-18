public class CountAndSay
{
    public static void main(String args[])
    {
        int count =4;
        String N1= "1";
        String str = "11";
        String temp ="";
        char[] c = str.toCharArray();
        str =str+"$";
        for(int i=3; i <count;i++)
        {
            int occur=1;
            for(int j=1;j <c.length;j++ )
            {

                if(c[j-1] != c[j])
                {
                    temp=temp+occur;
                    temp = temp+c[j-1];
                    count=1;
                }
                else
                {
                    occur++;
                }
            }
            str =temp;

        }
        System.out.println(str);

    }
}
