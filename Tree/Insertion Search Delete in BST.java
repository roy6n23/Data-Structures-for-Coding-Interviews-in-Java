//----------------Iterative--------------------
//----------------Iterative--------------------
//----------------Iterative--------------------
//----------------Iterative--------------------
//----------------Iterative--------------------
//----------------Iterative--------------------
//----------------Iterative--------------------


class binarySearchTree{

	private Node root;

	public Node getRoot(){
		return root;
	}

	public void setRoot(Node root){
		this.root = root;
	}


    public Node search(int value) {
        if (isEmpty()) return null; // if tree is empty simply return null
        Node currentNode = this.root;
        while (currentNode != null) {
            if (currentNode.getData() == value) return currentNode; // compare data from current node
            
            if (currentNode.getData() > value) //if data from current node is greater than value
                currentNode = currentNode.getLeftChild(); // then move towards left subtree
            else 
                currentNode = currentNode.getRightChild(); //else move towards right subtree
        }
        System.out.println(value + " Not found in the Tree!");
        return null;
    }



	//Iterative Function to insert a value in BST
	public boolean add(int value){

		if(isEmpty()){

			root = new Node(value);
			return true;
		}

		Node currentNode = root;

		while(currentNode != null){

			Node leftChild = currentNode.getLeftChild();
			Node rightChild = currentNode.getRightChild();



			if(currentNode.getData() > value){
				if(leftChild == null){
					leftChild = new Node(value);
					currentNode.setLeftChild(leftChild);
					return true;
				}

				currentNode = leftChild;

			}

			else{
				if(rightChild == null){
					rightChild = new Node(value);
					currentNode.setRightChild(rightChild);
					return true;
				}

				currentNode = rightChild;
			}

		}
	}
	return false;


	//3 conditions for delete
	//1.node is leaf node.
	//2.node has 1 child.
	//3.node has 2 children.
	boolean delete(int value, Node currentNode) {
       
        if (root == null) {
            return false;
        } 

        Node parent = null; //To Store parent of currentNode
        while(currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();
            
        }
       
        if(currentNode == null) {
            return false;
        }
        else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is Leaf Node
            //if that leaf node is the root (a tree with just root)
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
				parent.setLeftChild(null);
                return true;
             }
            else{
                parent.setRightChild(null);
                return true;
            }
        } else if(currentNode.getRightChild() == null) {
            //delete the root while is only leftchild
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            }
            else{

                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }

        }
        else if(currentNode.getLeftChild() == null) {
            
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }

        }
        else {
            //Find Least Value Node in right-subtree of current Node
            Node leastNode = findLeastNode(currentNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }

    }

	//Helper function to find least value node in right-subtree of currentNode
	private Node findLeastNode(Node currentNode) {

		Node temp = currentNode;

		while (temp.getLeftChild() != null) {
			temp = temp.getLeftChild();
		}

		return temp;

	}


	public boolean isEmpty(){

		return root == null;
	}

	public void printTree(Node current){
		if(current == null) return;

		System.Out.print(current.getData() + ",");

		printTree(current.getLeftChild());
		printTree(current.getRightChild());
	}
}








//------------------------Recursive----------------------
//------------------------Recursive----------------------
//------------------------Recursive----------------------
//------------------------Recursive----------------------
//------------------------Recursive----------------------
//------------------------Recursive----------------------
//------------------------Recursive----------------------
//------------------------Recursive----------------------


class binarySearchTree {

	private Node root;


	public Node getRoot() {
		return root;
    }
    
		
	public void setRoot(Node root) {
		this.root = root;
	}


	//Searches value in BST
	//Either returns the Node with that value or return null
	public Node search(int value) {

		if (isEmpty()) 
			return null; // if tree is empty simply return null

		Node currentNode = this.root;

		while (currentNode != null) {

			if (currentNode.getData() == value) return currentNode; // compare data from current node
			
			if (currentNode.getData() > value) //if data from current node is greater than value
				currentNode = currentNode.getLeftChild(); // then move towards left subtree
			else 
				currentNode = currentNode.getRightChild(); //else move towards right subtree
		}

		System.out.println(value + " Not found in the Tree!");

		return null;
	}


	//Wrapper function for recursive search
	public Node search(int value) {

		if (isEmpty()) return null; // if tree is empty simply return null

		// return the output of the recursive search
		return searchRecursive(root, value);
	}

	//Recursive search function
	public Node searchRecursive(Node currentNode, int value){
		// if node is null or value is found then return node
		if (currentNode==null || currentNode.getData() == value) 
			return currentNode; 
		
		// if value is greater than node's data then search left sub-tree 
		if (currentNode.getData() > value){
			return searchRecursive(currentNode.getLeftChild(), value);
		} 
		else{
		// if value is less than node's data then search right sub-tree 
			return searchRecursive(currentNode.getRightChild(), value); 
		}
	}



	//Recursive function to insert a value in BST 
	public Node recursive_insert(Node currentNode, int value) {

		//Base Case
		if (currentNode == null) {
			return new Node(value);
		}

		if (value < currentNode.getData()) {
			//Iterate left sub-tree
			currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
		} else if (value > currentNode.getData()) {
			//Iterate right sub-tree
			currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
		} else {
			// value already exists
			return currentNode;
		}

		return currentNode;

	}

	//Function to call recursive insert
	public boolean add(int value) {

		root = recursive_insert(this.root, value);
		return true;
	}

	//Function to check if Tree is empty or not  
	public boolean isEmpty() 
    {
		return root == null; //if root is null then it means Tree is empty
	}

	//Just for Testing purpose 
	public void printTree(Node current) 
    {
		if (current == null) return;

		System.out.print(current.getData() + ",");
		printTree(current.getLeftChild());
		printTree(current.getRightChild());

	}
}