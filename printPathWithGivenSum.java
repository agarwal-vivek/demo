package tree;

import java.util.ArrayList;

public class printPathWithGivenSum
{

    public static void main(String[] args)
    {

/*             1
       2           3
     4    5      6    7*/

        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.right.left.left = newNode(8);
        root.right.right.right = newNode(9);

        int sum = 11;

        ArrayList l = new ArrayList();
        printValidPath( root,sum,l);

    }


    public static void printValidPath(Node root,int sum,ArrayList list)
    {

        if(root == null)
        {
            // don't have any path
            return ;
        }

        if(sum == 0)
        {
            for(int i=0;i<list.size();i++)
                System.out.println(((Node)list.get( i ) ).data);
            //print the list
        }

        list.add(root);





        printValidPath(root.left,sum-root.data,list);
        printValidPath(root.right,sum-root.data,list);

        list.remove( list.size()-1);
         sum=sum+root.data;

    }


    static class Node
    {
        Node left;
        Node right;
        int data;
    };

    // Function to create a new
    // Binary node
    static Node newNode( int data)
    {
        Node temp = new Node();

        temp.data = data;
        temp.left = null;
        temp.right = null;

        return temp;
    }


}
