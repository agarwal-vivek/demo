package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class BreathFirstTraversal
{



    public static void main(String args[])
    {

        Graph g = new Graph(4);

        g.putEdge(0, 1);
        g.putEdge(0, 2);
        g.putEdge(1, 2);
        g.putEdge(2, 0);
        g.putEdge(2, 3);
        g.putEdge(3, 3);
        g.BFT( 2 );
    }
}


class Graph
{
    int vertex;
    ArrayList<Integer>[] adjList;

    public Graph(int v)
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

    public void BFT(int u)
    {

        boolean[] visited = new boolean[this.vertex];

        visited[u] = true;

        LinkedList queue = new LinkedList();
        queue.add(u);

        while(queue.size() != 0)
        {
            int vet = (int)queue.poll();
            System.out.println(" "+ vet);

            ListIterator it = adjList[vet].listIterator();


            while(it.hasNext())
            {
               int edge = (int)it.next();
               if(visited[edge] != true)
               {
                   visited[edge] =true;
                   queue.add(edge);
               }

            }
        }

    }
}
