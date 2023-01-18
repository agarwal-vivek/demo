import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CustomLRU
{

    public static void main(String args[])
    {

    }



}

class LRUCache
{
    Deque<node> q = new LinkedList<node>();
    Map<Integer,node> cache = new HashMap();



    public int getdata(int k)
    {
        node n= null;
        if(cache.containsKey( k ))
        {
             n = cache.get(k);
            q.remove(n);
            q.addFirst(n);

        }
         return n.getValue();
    }


    public void add(int k, int value)
    {
        if(cache.containsKey( k ))
        {

        }



    }


}

class node
{
 int key;
 int value;

    public int getKey()
    {
        return key;
    }

    public void setKey( int key )
    {
        this.key = key;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue( int value )
    {
        this.value = value;
    }

    public node getNext()
    {
        return next;
    }

    public void setNext( node next )
    {
        this.next = next;
    }

    public node getPrev()
    {
        return prev;
    }

    public void setPrev( node prev )
    {
        this.prev = prev;
    }

    node next;
 node prev;

}


