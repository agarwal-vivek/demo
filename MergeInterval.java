import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval
{

    int start;
    int end;

    public Interval(int s, int e)
    {
        this.start=s;
        this.end=e;
    }

    public int getStart()
    {
        return start;
    }

    public void setStart( int start )
    {
        this.start = start;
    }

    public int getEnd()
    {
        return end;
    }

    public void setEnd( int end )
    {
        this.end = end;
    }

}


public class MergeInterval
{
    public static void main(String[] args)
    {
        Interval[] interval = new Interval[4];

        interval[0]=new Interval(6,8);
        interval[1]=new Interval(1,9);
        interval[2]=new Interval(2,4);
        interval[3]=new Interval(4,7);

        mergeInterval(interval,4);
    }

    private static void mergeInterval(Interval[] interval,int n)
    {
        Stack stack = new Stack();
        Arrays.sort( interval, new Comparator<Interval>()
        {
            @Override public int compare( Interval o1, Interval o2 )
            {
                return (o1.start - o2.start);
            }
        } );



        stack.push(interval[0]);

         Interval node = (Interval)stack.peek();
        for(int i=1; i< interval.length;i++)
        {

            if(node.end <interval[i].start)
            {
                stack.push(interval[i]);
            }
            if(node.end >= interval[i].start)
            {
                interval[i].start = node.start;
                stack.pop();
                stack.push(interval[i]);
            }
        }

        while (!stack.isEmpty())
        {
            Interval t = (Interval)stack.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }


    }
}
