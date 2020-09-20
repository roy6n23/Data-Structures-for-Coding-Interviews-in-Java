	//--------------------Sorting the tree in order----------------------
	//--------------------Sorting the tree in order----------------------
	//--------------------Sorting the tree in order----------------------
	//--------------------Sorting the tree in order----------------------
	//--------------------Sorting the tree in order----------------------


class CheckKthMax {

  public static int findKthMax(Node root, int k) {

    //Perform In-Order Traversal to get sorted array. (ascending order)
    //Return value at index [length - k]
    StringBuilder result = new StringBuilder(); //StringBuilder is mutable
    result = inOrderTraversal(root, result);

    String[] array = result.toString().split(","); //Spliting String into array of strings
    if ((array.length - k) >= 0) return Integer.parseInt(array[array.length - k]);

    return - 1;
  }

  //Helper recursive function to traverse tree using inorder traversal
  //and return result in StringBuilder
  public static StringBuilder inOrderTraversal(Node root, StringBuilder result) {

    if (root.getLeftChild() != null) inOrderTraversal(root.getLeftChild(), result);

    result.append(root.getData() + ",");

    if (root.getRightChild() != null) inOrderTraversal(root.getRightChild(), result);

    return result;
  }

  public static void main(String args[]) {

    binarySearchTree bsT = new binarySearchTree();

    bsT.add(6);

    bsT.add(4);
    bsT.add(9);
    bsT.add(5);
    bsT.add(2);
    bsT.add(8);

    System.out.println(findKthMax(bsT.getRoot(),3));
  }
}




	//-------------------------Recursive Approach-----------------------
  	//-------------------------Recursive Approach-----------------------
  	//-------------------------Recursive Approach-----------------------
  	//-------------------------Recursive Approach-----------------------
  	//-------------------------Recursive Approach-----------------------


class CheckKthMax {

  static int  counter; //global count variable
  //used as a wrapper for the recursive algorithm
  public static int findKthMax(Node root, int k) {
    counter = 0;
    Node node = findKthMaxRecursive(root, k);
    if(node != null)
      return node.getData();
    return -1;
  }
  
  public static Node findKthMaxRecursive(Node root, int k) {
    if(root==null){
      return null;
    }
    //Recursively reach the right-most node (which has the highest value)
    Node node = findKthMaxRecursive(root.getRightChild(), k);

    if(counter != k){
      //Increment counter if kth element is not found
      counter++;
      node = root;
    }
    //Base condition reached as kth largest is found
    if(counter == k){
      return node;
    }else{
      //Traverse left child if kth element is not reached
      return findKthMaxRecursive(root.getLeftChild(), k);
    }
  }

  public static void main(String args[]) {

    binarySearchTree bsT = new binarySearchTree();

    bsT.add(6);
    bsT.add(4);
    bsT.add(9);
    bsT.add(5);
    bsT.add(2);
    bsT.add(8);

    System.out.println(findKthMax(bsT.getRoot(),3));
  }
}