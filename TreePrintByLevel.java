import java.util.LinkedList;


public class TreePrintByLevel {
	
	
	
	public void treeLevelPrint(TreeNode node){
		
		LinkedList list = new LinkedList();
		if(node != null){
			list.add(node);
		}
		
		while(list.size() != 0){
			
			TreeNode nd = (TreeNode)list.getFirst();
			System.out.println(nd.iData);
			 list.removeFirst();
			if(nd.getLeftChild() != null){
				list.add(nd.getLeftChild());
			}
			if(nd.getRightChild() != null){
				list.add(nd.getRightChild());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]) throws Exception 
	{
		
		BinaryTree tree = new BinaryTree();
		tree.makeTree();
		TreeNode node = tree.getBinaryTree();
		
		TreePrintByLevel treelevelprinting = new TreePrintByLevel();
		treelevelprinting.treeLevelPrint(node);
		
	}


}
