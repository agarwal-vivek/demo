package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class DepthFirstTraversal
{


    public static void main(String args[])
    {

        DFSGraph g = new DFSGraph(4);

        g.putEdge(0, 1);
        g.putEdge(0, 2);
        g.putEdge(1, 2);
        g.putEdge(2, 0);
        g.putEdge(2, 3);
        g.putEdge(3, 3);
        g.DFS( 2 );
    }
}


class DFSGraph
{
    int vertex;
    ArrayList<Integer>[] adjList;

    public DFSGraph(int v)
    {
        this.vertex = v;

        adjList = new ArrayList[v];
        for(int i=0;i<v;i++)
        {
            adjList[i] = new ArrayList();
        }

    }

    public void putEdge(int u, int v)
    {
        adjList[u].add(v);

    }


    public void DFSUtils(int e)
    {


    }
    public void DFS(int u)
    {

        boolean[] visited = new boolean[this.vertex];



        Stack s = new Stack();
        s.push(u);

        while(s.size() != 0)
        {
            int vet = (int)s.pop();
            visited[u] = true;
            System.out.println(" "+ vet);

            ListIterator it = adjList[vet].listIterator();


            while(it.hasNext())
            {
                int edge = (int)it.next();
                if(visited[edge] != true)
                {
                    visited[edge] =true;
                    s.push(edge);
                }

            }
        }

    }
}
