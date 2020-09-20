class CheckMin 
{


	//----------ITERATIVE-------------
	//----------ITERATIVE-------------
	public static int findMin(Node root) {
	if(root == null)
		return -1;

	while(root.getLeftChild() != null){
		root = root.getLeftChild();
	}

	return root.getData();
	}


	//----------RECURSIVE------------
	//----------RECURSIVE------------
	//----------RECURSIVE------------

	public static int findMin(Node root){
		if(root == null)
			return -1;
		else if(root.getLeftChild() == null)
			return root.getData();
		else
			return findMin(root.getLeftChild());
	}



	 public static void main(String args[]) {

        binarySearchTree bsT = new binarySearchTree();
        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println(findMin(bsT.getRoot()));

    }
}