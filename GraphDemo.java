import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GraphDemo
{

    private int vert;
    private List<Integer> edges[] = new ArrayList[vert];

    public GraphDemo(int vert)
    {
        this.vert = vert;

        for(int i=0;i< vert;i++)
        {
            edges[i] = new ArrayList<Integer>();
        }
    }

    public void addEdges(int source, int dest)
    {
        edges[source].add(dest);
        edges[dest].add(source);
    }

    public void traverse(int s)
    {

      boolean visited[] = new boolean[vert];

      Stack<Integer> stack = new Stack<Integer>();

      for(int i=0;i< vert;i++)
      {
          visited[i] = false;
      }

       stack.push(s);


      while(!stack.isEmpty())
      {

        int src=  stack.pop();
        List<Integer> edge = edges[src];

        for( Integer e:edge)
        {
           if(visited[e] == false)
           {
               stack.push(e);
           }
        }

      }


    }
}
