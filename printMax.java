package tree;


public class printMax {



   public static void main(String[] args){

       Node root =  newNode(1);
       root.left = newNode(2);
       root.right = newNode(3);
       root.left.left = newNode(4);
       root.left.right = newNode(5);
       root.left.right.right = newNode(6);
       int max=0;
       max =findMax(root);
       System.out.println("max =" + max);
   }

    private static int findMax(Node root) {

      int lMax=0;
      int rMax=0;
      int max=0;

      if(root == null)
          return 0;
        max = root.data;

        //  if(root.left != null)
          lMax = findMax(root.left);
      if(root.right != null)
          rMax = findMax(root.right);

      if(max < lMax)
          max = lMax;
      if(max < rMax )
          max =rMax;

        return max;

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


