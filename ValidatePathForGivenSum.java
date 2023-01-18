package tree;

import java.util.ArrayList;

public class ValidatePathForGivenSum
{

    public static void main(String[] args)
    {

        Node root =  newNode( 1);


        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.left.right.right = newNode(6);

         int sum = 7;

        boolean result= validPath( root,sum);

        if(result)
        {
            System.out.println( "Valid path is exisit" );
        }

/*        System.out.println("result " + result.size());
        result.forEach(r->System.out.println(r)  );*/
    }

      public static boolean validPath(Node root, int sum)
      {

          boolean leftpath= false;
          boolean rightpath = false;
          if(root == null)
          {
              return (sum == 0);


          }
/*
          if(sum == 0)
          {
              System.out.println("Valid path is exisit");

          }*/
        //  if(root.left != null)
          leftpath =validPath(root.left,sum-root.data);

       //   if(root.right != null)
          rightpath =validPath(root.right,sum-root.data);

          return (leftpath ||rightpath );

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
