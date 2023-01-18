package tree;

import java.util.ArrayList;

public class printAllAncestor
{

    public static void main(String[] args)
    {

/*             1
       2           3
     4    5      6    7*/

        Node root = newNode( 1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.right.left = newNode(6);
        root.right.right = newNode(7);
        root.right.left.left = newNode(8);
        root.right.right.right = newNode(9);

        int data = 7;

        ArrayList l = new ArrayList();
        printAnsestor( root,l, data);

    }


    public static void printAnsestor(Node root,ArrayList list, int num)
    {

        if(root == null)
        {
            return;
        }

        if(root.data == num)
        {
         //print list
            for(int i=0;i<list.size();i++)
                System.out.println( list.get( i ));

        }
        list.add(root.data);

        printAnsestor(root.left,list,num);
        printAnsestor(root.right,list,num);

        list.remove(list.size()-1  );


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
