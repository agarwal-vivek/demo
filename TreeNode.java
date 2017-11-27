public class TreeNode {

	int iData;
	TreeNode leftChild;
	TreeNode rightChild;

	TreeNode(int num) {
		this.iData = num;
		this.leftChild = null;
		this.rightChild = null;
	}

	public int getiData() {
		return iData;
	}

	public TreeNode getLeftChild() {
		return leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setiData(int iData) {
		this.iData = iData;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}


}
