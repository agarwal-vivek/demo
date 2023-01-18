package tree;

import java.util.ArrayList;

public class MaxPathSum
{


    public static void main(String args[])
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

    ArrayList l = new ArrayList();
    int result =    printMaxSumPath( root,0);
   System.out.println("max sum = " + result);
}


    public static int printMaxSumPath( Node root, int sum)
    {

        //int sum =0;
        int maxSum=0;
        if(root == null)
        {
            if(sum > maxSum)
                maxSum = sum;
            return maxSum;
        }
      //  sum = sum + root.data;
         int leftSum = 0;
         int rightSum = 0;
       leftSum= printMaxSumPath(root.left,sum + root.data);
        rightSum =printMaxSumPath(root.right,sum+root.data);

        if(leftSum > rightSum)
            sum = leftSum;
        else
            sum = rightSum;
       return sum;

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
