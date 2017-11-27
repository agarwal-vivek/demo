import java.util.ArrayList;


public class PrintTreeAllroute {
	
	
	private void calculateRoute(TreeNode node ,ArrayList<Integer> path){
		
		path.add(node.iData);
		
		if(node.getLeftChild() == null && node.getRightChild() == null){
			
			printRoute(path);
		}
		
		if(node.getLeftChild() != null){
			calculateRoute(node.getLeftChild(),new ArrayList<Integer>());
		}
		
		if(node.getRightChild() != null) {
			calculateRoute(node.getRightChild(),new ArrayList<Integer>());
		}
		
	}
	
	 private void printRoute(ArrayList<Integer> path){

		for (Integer i : path) 
		{
			System.out.print(i + " ");
		}
		System.out.println();
	 }
	
	
	private void printalltreeroute(TreeNode node){
		
		if(node != null){
			ArrayList<Integer> path = new ArrayList<Integer>();
			
			calculateRoute(node,path);
			
			
			
			
		}
	}
	
	
	
	
	
	public static void main(String args[]) throws Exception 
	{
		
		BinaryTree tree = new BinaryTree();
		tree.makeTree();
		TreeNode node = tree.getBinaryTree();
		
		PrintTreeAllroute printAllroute = new PrintTreeAllroute();
		printAllroute.printalltreeroute(node);
		
	}

}
