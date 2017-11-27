
public class MaxInTree {
	
	BinaryTree tree;
	
	MaxInTree()
	{
	}
	
	private int findMaxInTree(TreeNode node) throws Exception{
		
		int max = 0;
		TreeNode tnode ;
		
		MyStackImpl stack = new MyStackImpl(50);
		stack.push(node);
		
		while(!stack.isStackEmpty()){
			
		 tnode = (TreeNode)stack.pop();
		
		if(max < tnode.getiData()){
			max = tnode.getiData();
		}
		
		if(tnode.getLeftChild()!= null){
			stack.push(tnode.getLeftChild());
		}
		if(tnode.getRightChild()!= null){
			stack.push(tnode.getRightChild());
		}
		
		
		}
		
		return max;
	}
	
	
	
	
	
	public static void main(String args[]) throws Exception 
	{
		
		BinaryTree tree = new BinaryTree();
		MaxInTree maxTree = new MaxInTree();
		tree.makeTree();
		TreeNode node = tree.getBinaryTree();
		int max = maxTree.findMaxInTree(node);

		System.out.println("Maximum number in binary tree=" + max);
		
	}

}
