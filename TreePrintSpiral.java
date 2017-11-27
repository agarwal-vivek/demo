
public class TreePrintSpiral {
	
	
	public void printSpiral(TreeNode node){
		
		MyStackImpl s1 = new MyStackImpl(50);
		MyStackImpl s2 = new MyStackImpl(50);
		
		try {

			s1.push(node);

			while(!s1.isStackEmpty()){
			TreeNode temp = (TreeNode)s1.pop();
			
			System.out.println(temp.iData);
			
			if(temp.getLeftChild()!= null){
				s2.push(temp.getLeftChild());
			}
			if(temp.getRightChild()!= null){
				s2.push(temp.getRightChild());
			}
			
			
			while(!s2.isStackEmpty()) {
				
			 TreeNode nd = (TreeNode)s2.pop();
			  System.out.println(nd.iData);
			
			if(nd.getLeftChild() != null){
				s1.push(nd.getLeftChild());
			}
			if(nd.getRightChild() != null){
				s1.push(nd.getRightChild());
			}
			
			}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) throws Exception 
	{
		
		BinaryTree tree = new BinaryTree();
		tree.makeTree();
		TreeNode node = tree.getBinaryTree();
		
		TreePrintSpiral tSpiralPrinting = new TreePrintSpiral();
		tSpiralPrinting.printSpiral(node);
		
	}

}
