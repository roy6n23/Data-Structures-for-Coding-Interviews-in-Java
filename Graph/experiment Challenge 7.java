class CheckTree {
    public static boolean isTree(Graph g) {
    	//checkoneparent should return true
       if(!CheckOneParent(g))
       	return false;
       //should return false
       if(detectCycle(g))
       	return false;
       //should return true
       if(!checkConnected(g, 0))
       	return false

       return true;
    }


    public static boolean detectCycle(Graph g){
    	int nums_of_vertics = g.vertics;

    	boolean[] visited = new boolean[nums_of_vertics];
    	boolean[] stackFlag = new boolean[nums_of_vertics];

    	for(int i = 0; i < nums_of_vertics; i++){

    		if (cyclic(g, i, visited, stackFlag)) {
    			return true;
    			
    		}
    	}
    	return false;

    }

    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag){
    	//if node is currently in stack that means we have found a cycle
    	if(stackFlag[v])
    		return true;

    	//if it is already visited (and not in Stack) then there is no cycle
    	if(visited[v])
    		return false;

    	visited[v] = true;
    	stackFlag[v] = true;

    	DoublyLinkedList<Integer>.Node temp = null;
    	if(g.adjacencyList[v] != null)
    		temp = g.adjacencyList[v].headNode;

    	while(temp != null){
    		if(cyclic(g, temp.data, visited, stackFlag)){
    			return true;
    		}

    		temp = temp.nextNode;
    	}
    	stackFlag[v] = false;

    	return false;
    }

    public static boolean CheckOneParent(Graph g){
    	int nums_of_vertics = g.vertics;
    	boolean[] hasOneParent = new boolean[nums_of_vertics];

    	for(int i = 0; i < nums_of_vertics; i++){
    		DoubleLinkedList<Integer> .Node temp = null;
    		if(g.adjacencyList[i] != null){
    			temp = g.adjacencyList[i].headNode;
    			while(temp != null){
    				if(hasOneParent[temp.data])
    					return false;
    				hasOneParent[temp.data] = true;
    				temp = temp.nextNode;
    			}
    		}
    	}

    	for (int i = 0; i < nums_of_vertics; i++){

    		if(i == 0 && hasOneParent[i] == true){

    			return false;
    		}

    		else if( i != 0 && hasOneParent[i] == false){
    			return false;
    		}
    	}

    	return true;
    }

    private static boolean checkConnected(Graph g, int source){

    	int nums_of_vertics = g.vertics;
    	int vertics_reached = 0;

    	boolean[] visited = new boolean[nums_of_vertics];

    	Stack<Integer> stack = new Stack<>(nums_of_vertics);

    	stack.push(source);
    	visited[source] = true;

    	while(!stack.isEmpty()){

    		int current_node = stack.pop();

    		DoublyLinkedList<Integer>.Node temp = null;
    		if(g.adjacencyList[current_node] != null)
    			temp = g.adjacencyList[current_node].headNode;

    		while(temp != null){

    			if( !visited[temp.data]){
    				stack.push(temp.data);
    				visited[temp.data] = true;
    				vertics_reached++;
    			}

    			temp = temp.nextNode;
    		}

    	}

    	return (vertics_reached + 1) == g.vertics;
    }
}