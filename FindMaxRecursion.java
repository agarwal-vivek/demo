package tree;

public class FindMaxRecursion
{
    public static int max=0;

    public static void main(String args[])
    {

        Node root =  newNode( 1);


        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.left.right.right = newNode(6);

         int result = findMax(root);
         System.out.println("max value =" + result);

    }

    public static int findMax(Node node)
    {
        if(node == null)
            return Integer.MIN_VALUE;
        if(node.data > max)
        {
            max = node.data;
        }
        findMax( node.left );
        findMax( node.right );

        return max;
    }
/*
   public static int findMax(Node node)
   {
       int lMax = Integer.MIN_VALUE;
       int rMax = Integer.MIN_VALUE;
       if(node == null)
           return Integer.MIN_VALUE;

         int data = node.data;
         lMax =   findMax( node.left );
         rMax =  findMax(  node.right );

         int res = 0;
         if(lMax>=rMax)
             res = lMax;
         else
             res= rMax;
         if(res <data)
           res=data;
        return res;
   }
*/



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
