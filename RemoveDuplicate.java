public class RemoveDuplicate
{


    public static void main(String[] args)
    {
          String s = "DBAABDAB";
          int len = s.length();
          System.out.println(removeAdjDup(s,len));

    }

    public static String removeAdjDup(String s,int n)
    {
        int i,j=0;
        char arr[] = s.toCharArray();
        for(i=0;i< s.length()-1;i++)
        {

           if(arr[i] != arr[i+1])
           {
               arr[j] = arr[i];
               j++;
           }
           else
           {
               while(arr[i] == arr[i+1])
               {
                   i++;
               }
           }

        }
        arr[j++] = arr[i];


        s = new String(arr).substring(0, j);
        if (j != n) {
           return removeAdjDup( s, j );
        }
        return s;
    }
}
