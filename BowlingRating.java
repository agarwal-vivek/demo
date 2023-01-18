public class BowlingRating
{



    public static void main(String[] args)
    {


        String str = "-12/369/--5/8/11221/3";
        int finalScore=0;

        char[] score = str.toCharArray();
        int[] result = new int[score.length];

        for(int i =0; i< score.length;i++)
        {

            if(score[i] == '-')
            {
                result[i] =0;
            }
            else if(score[i] == 'X'){
                result[i] =10;
            }

            else if(score[i] == '/')
            {
                result[i] =10 - Character.getNumericValue(score[i-1] );//new Integer(score[i-1]).intValue();
            }
            else{
                result[i] =    Character.getNumericValue(score[i] )  ;   // int)new Integer( (intscore[i]  ).intValue();

            }


        }

        for(int j=0;j<result.length;j++)
        {
            System.out.println( result[j] );
        }

        for(int i =0; i< result.length;i++)
        {
            if(result[i] == 10)
            {
                result[i] = result[i] + result[i+1] + result[i+2];
            }


            finalScore = finalScore +  result[i];
        }

        System.out.println("Final score =" + finalScore);
 /*

        int maxTurn = 21;

        if(str.length() < 20 || str.length() >21)
        {
            System.out.println("Invalid input");
        }

        str.replaceAll( "-","0" );
        for(int i=0; i<str.length();i++)
        {
            if(str.charAt(i) == '/')
            {
              int num=  10- new Integer(str.charAt(i-1)).intValue() + new Integer(str.charAt(i+1)).intValue() ;
              str.replace("/",String.valueOf( num )  );

            }

            //int[] turn = new int[str.length()-1];
            int result = 0;
            for(int j=0;j< str.length()-1;j++)
            {
                result = result + new Integer(str.charAt( j )).intValue();


            }



        }*/



    }

/*    "-"  miss
    "/"*/
/*    -12/369/--8/5/11221/3. >>> 78
        -1 > 1
        2/ > 13
        36 > 9
        9/ > 10
        -- > 0
        8/ > 15
        5/ > 11
        11 > 2
        22 > 4
        1/3 >13*/


}
