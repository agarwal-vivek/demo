package tree;

import java.util.ArrayList;
import java.util.List;

public class LongestPath
{


    public static void main(String[] args)
    {

        Node root =  newNode(1);


        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.left.right.right = newNode(6);

        ArrayList list = new ArrayList();
        ArrayList result=  printLongestPath( root,list);

        System.out.println("result " + result.size());
        result.forEach(r->System.out.println(r)  );
    }

    public static ArrayList printLongestPath(Node root, ArrayList list)
    {

        ArrayList l = new ArrayList();
        l.add(root);
        ArrayList rightList = new ArrayList();
        ArrayList leftList = new ArrayList();

        if(root == null)
            return l;

        if(root.right !=null)
        {
            //   l.add(root);
            rightList = printLongestPath(root.right,rightList);
        }
        if(root.left !=null)
        {
            //    l.add(root);
            leftList= printLongestPath(root.left,leftList);

        }

        if(leftList.size() >rightList.size() )
            l.addAll(leftList);
        else
            l.addAll(rightList);

        return l;
    }



    static class Node
    {
        Node left;
        Node right;
        int data;
    };

    // Function to create a new
    // Binary node
    static Node newNode(int data)
    {
        Node temp = new Node();

        temp.data = data;
        temp.left = null;
        temp.right = null;

        return temp;
    }

}

