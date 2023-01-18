package tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

public class BasicTreeQuestion {


    public static void main(String[] args)
    {

        Node root =  newNode( 1);

        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.right = newNode(5);
        root.left.right.right = newNode(6);

      //   System.out.println(findElement(root,7));
      //  System.out.println("size =" + getSize(root));
     //   levelOrderPrinting(root);
      //  levelOrderPrintingReverseOrder(root);
      //  System.out.println( findTreeHeight(root));
      //  getTreeHeightNonRecursive(root);
      //  levelOrderSpiralPrinting(root);
      //  LevelWithMaxSum(root);
        List l = new ArrayList();
        printAllPath(root,l);
    }


    private static void printAllPath(Node root, List l)
    {
        Queue q = new LinkedList();

        // List L = new ArrayList();

        if(root.left == null || root.right == null){

            l.forEach(System.out::println);
           // l.remove(root);
        }

        System.out.println("\n");

        q.add(root);

        while(!q.isEmpty()) {

            Node n = (Node)q.poll();
            l.add(n.info);

            if (n != null && n.left != null)
                printAllPath(n.left, l);

            if (n != null && n.right != null)
                printAllPath(n.right, l);

        }
        }
    private static boolean findElement(Node root,int data)
    {

        if(root == null)
            return false;

        if(root.info == data )
            return true;

        return (findElement(root.left,data)|| findElement(root.right,data));


    }

    private static void levelOrderPrinting(Node root)
    {

        Queue q = new ArrayBlockingQueue(10);
        q.add(root);

        while(!q.isEmpty())
        {

            Node n = (Node)q.poll();
            System.out.println(n.info);

            if(n !=null && n.left!= null)
               q.add(n.left);
            if(n !=null && n.right != null)
                q.add(n.right);
        }

    }


    private static void levelOrderSpiralPrinting(Node root)
    {

        Queue q = new LinkedList();
        Queue out = new LinkedList();

        q.add(root);
        boolean bool = true;
        while(!q.isEmpty())
        {

            Node n = (Node)q.poll();
             out.add(n.info);

           if(bool){

               if(n != null && n.left != null)
               {
                   q.add(n.left);
               }
               if(n != null && n.right != null)
               {
                   q.add(n.right);
               }
              bool = false;

           }
           else {


               if(n != null && n.right != null)
               {
                   q.add(n.right);
               }
               if(n != null && n.left != null)
               {
                   q.add(n.left);
               }
               bool = true;
           }
        }


         while(!out.isEmpty())
         {
             System.out.println(out.poll());
         }



    }


    private static void levelOrderPrintingReverseOrder(Node root)
    {
        Queue q = new ArrayBlockingQueue(10);
        Stack s = new Stack();

        q.add(root);


        while(!q.isEmpty())
        {

            Node n = (Node)q.poll();

            s.push(n.info);

            if(n != null && n.left != null)
            {
                q.add(n.left);
            }
            if(n != null && n.right != null)
            {
                q.add(n.right);
            }
        }

        while(!s.isEmpty())
        {
            System.out.println(s.pop());
        }
    }

    private static int findTreeHeight(Node root)
    {


        int leftHeight = (root.left !=null)?findTreeHeight(root.left):0;
        int   rightHeight = (root.right !=null)?findTreeHeight(root.right):0;


        if(leftHeight > rightHeight )
            return leftHeight+1;
        else
            return rightHeight+1;
    }

    private static void getTreeHeightNonRecursive(Node root)
    {
        int len =0;
        Queue q = new LinkedList();

        q.add(root);
        q.add(null);

        while(!q.isEmpty()) {

            Node n = (Node) q.poll();

            if (n == null && q.size() != 0) {
                q.add(null);
                ++len;
            }

            if (n != null && n.left != null)
                q.add(n.left);
            if (n != null && n.right != null)
                q.add(n.right);
        }
        System.out.println("length =" + len);
    }

    private static void LevelWithMaxSum(Node root)
    {

        Queue s = new LinkedList();
        s.add(root);
        s.add(null);
        int sum =0;
        int count =0;
        int maxSum=0;
        int level =0;
        while(!s.isEmpty())
        {

            Node n = (Node)s.poll();

            if(n == null && !s.isEmpty()){
                ++count;
                s.add(null);
                if(maxSum < sum){
                    maxSum = sum;
                    level = count;
                }
                sum =0;
            }
            else{

                if(n != null && n.left !=null)
                    s.add(n.left);
                if(n != null && n.right !=null)
                    s.add(n.right);

                if(n != null)
                    sum = sum+ n.info;

            }

        }
        System.out.println("Tree level = " + level + " Max sum = " + maxSum );

    }


    private static int getSize(Node root)
    {

        if(root== null)
        {
            return 0;
        }

        return getSize(root.left) + getSize(root.right)+1;

    }

    private static class Node {

        int info;
        Node left;
        Node right;

    }

    private static Node newNode(int info){

        Node n = new Node();
        n.info = info;
        n.left = null;
        n.right = null;
        return n;
    }
}
