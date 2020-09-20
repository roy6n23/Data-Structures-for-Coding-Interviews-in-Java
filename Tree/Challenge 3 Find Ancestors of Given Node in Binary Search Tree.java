class CheckAncestors {
  public static String findAncestors(Node root, int k) {
    String result = "";
    Node tempNode = root;
    while(tempNode != null && tempNode.getData() != k){
    	result = result + tempNode.getData() + ",";
    	if( k <= tempNode.getData()){
    		tempNode = tempNode.getLeftChild();
    	}

    	else{
    		tempNode = tempNode.getRightChild();
    	}
    }

    if(tempNode == null){
    	return "";
    }

    return result;
  }
}