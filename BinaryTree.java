
import java.math.*;
import java.util.Random;
public class BinaryTree {

	TreeNode node;
	
	BinaryTree()
	{
		 this.node = null;
	}
	
/*	public void insert(int num)
	{
		if(node == null){
			node = new TreeNode(num);
		}
       insert(this.node,num);
	}*/
	
	public TreeNode insert(TreeNode node ,int num)
	{
		
		if(node == null)
		{
			node = new TreeNode(num);
			
		}
		else if(num > node.iData){
			node.rightChild
			= insert(node.rightChild, num);
		}
		else
		{
			node.leftChild
			= insert(node.leftChild, num);

		}

		this.node = node;
		return node;
	}
	
	
	public void print() throws Exception {

		MyStackImpl stack = new MyStackImpl(50);
		stack.push(node);

		while (!stack.isStackEmpty()) {

			TreeNode myNode = ((TreeNode) stack.pop());

			System.out.println(myNode.iData + "--");

			if (myNode.getLeftChild() != null) {
				stack.push(myNode.getLeftChild());
			}
			if (myNode.getRightChild() != null) {
				stack.push(myNode.getRightChild());
			}

		}

	}
	public static void main(String args[]) throws Exception
	{
		BinaryTree Btree = new BinaryTree();
		
		TreeNode node = null;
		for(int count =0;count<10;count++){
		node = Btree.insert(node ,getRandomNumberInRange(1,100));
		}
	//	Btree.print();
		
	}
	
	public void makeTree() {
		
		BinaryTree Btree = new BinaryTree();
		
	    for(int count =0;count<10;count++)
	    {
		this.node = Btree.insert(node ,getRandomNumberInRange(1,100));
		}
		
	}
	
	public TreeNode getBinaryTree()
	{
		
		return node;
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
}
