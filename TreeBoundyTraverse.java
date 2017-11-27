
public class TreeBoundyTraverse {
	
	TreeNode node ;
	
	
	 private void printTreeleaf(TreeNode node){
		 
		 MyStackImpl stack = new MyStackImpl(50);
		 while(node != null)
		 {
		 if(node.getLeftChild() == null && node.getRightChild() == null)
		 {
			 System.out.println(node.iData);
		 }
			 
	     }
	 }
	
	 private void printLeftBoundry(TreeNode node){
		 
		 if(node != null)
		 {
		 
		 if(node.getLeftChild() != null)
		 {
			 System.out.println(node.iData);
			 printLeftBoundry(node.getLeftChild());
			 
		 }
		 
		 if (node.getRightChild() != null)
		 {
			 System.out.println(node.iData);
			 printLeftBoundry(node.getRightChild());			 
			 
		 }
		 
		 }
		 
		 
	 }
	
	 private void printRightBoundry(TreeNode node)
	 {
	
		 if(node != null)
		 {
		 
		 if(node.getRightChild() != null)
		 {
			 System.out.println(node.iData);
			 printLeftBoundry(node.getRightChild());
			 
		 }
		 
		 if (node.getLeftChild() != null)
		 {
			 System.out.println(node.iData);
			 printLeftBoundry(node.getLeftChild());			 
			 
		 }
		 
		 }
		 
		 
		 
	 }
	 
	 public void printTreeBoundry(TreeNode node) 
	 {
		 
		 
		 MyStackImpl stack = new MyStackImpl(50);
		 while(node != null){
			 
			 try {
				stack.push(node);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
		 }
		 
		 
	 }
	
	
	public static void main(String args[]){
		
		
		
		BinaryTree tree = new BinaryTree();
		tree.makeTree();
		TreeNode node = tree.getBinaryTree();
		
		TreeBoundyTraverse bTraverse = new TreeBoundyTraverse();
		
		
		
	}

}
