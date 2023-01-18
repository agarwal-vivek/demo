package Graph;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

public class DepthFirstRecursive
{


    public static void main(String args[])
    {

        DFSG g = new DFSG(4);

        g.putEdge(0, 1);
        g.putEdge(0, 2);
        g.putEdge(1, 2);
        g.putEdge(2, 0);
        g.putEdge(2, 3);
        g.putEdge(3, 3);
        g.DFS( 0);
    }
}


class DFSG
{
    int vertex;
    ArrayList<Integer>[] adjList;

    public DFSG(int v)
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


    public void DFSUtils(int e, boolean[] visited)
    {

        visited[e] = true;
        System.out.println(" "+ e);
       ListIterator lit= adjList[e].listIterator();
        if(lit.hasNext())
        {
            int node = (int)lit.next();
            if(visited[node] != true)
            DFSUtils(node,visited);

        }

    }
    public void DFS(int u)
    {

        boolean[] visited = new boolean[this.vertex];

        DFSUtils(u,visited);
  }
}
