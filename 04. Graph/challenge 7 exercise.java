class IsTree{

	public boolean isTree(Graph g){

	}

	public static boolean hasOneParent(Graph g){
		int num_of_vertices = g.vertices;
		boolean[] hasOneParent = new boolean[num_of_vertices];

		for(int i = 0; i < num_of_vertices; i++){
			DoublyLinkedList<Integer>.Node = temp;
			if(g.adjacencyList[i] != null){
				temp = g.adjacencyList[i].headNode;
			}

			while(temp != null){
				if(hasOneParent[temp.data] = true)
					return false;
				hasOneParent[temp.data] = true;
				temp = temp.nextNode;
			}
		}

		for(int i = 0; i < num_of_vertices; i++){
			if(i == 0 && hasOneParent[0] = true)
				return false;
			else if(i != 0 || hasOneParent[i] = false)
				return false;
		}


		return true;
	}


	public static boolean hasCircle(Graph g){

		boolean[] visited = new boolean[g.vertices];
		boolean[] stackFlag = new boolean[g.vertices];

		for(int i = 0; i < g.vertices; i++){
			if(cyclic(g, i, visited, stackFlag))
				return true;
		}

		return false;
	}

	public static boolean cyclic(Graph g, int source, boolean[] visited, boolean[] stackFlag){
		if(visited[source])
			return false;

		if(stackFlag[])
			return true;

		visited[source] = true;
		stackFlag[source] = true;

		DoublyLinkedList[source].Node temp = null;
		if(g.adjacencyList[source] != null){
			temp = g.adjacencyList[source].headNode;
		}

		while(temp != null){
			if(cyclic(g, temp.data, visited, stackFlag)){
				return true;
			}

			temp = temp.nextNode;
		}
		stackFlag[source] = false;

		return false;

	}

	public static boolean isConnected(Graph g, int source){

		int num_of_vertices = g.vertices;
		int countedNode = 0;

		boolean[] visited = new boolean[num_of_vertices];

		Stack<Integer> stack = new Stack<>(num_of_vertices);

		stack.push(source);
		visited[source] = true;

		while(!stack.isEmpty()){
			int current_ndoe = stack.pop();

			DoublyLinkedList<Integer>.Node temp = null;
			if(g.adjacencyList[source] != null)
				temp = g.adjacencyList[source].headNode;

			while(temp != null){
				if(!visited[temp.data]){
					stack.push(temp.data);
					visited[temp.data] = true;
					countedNode++;
				}

				temp = temp.nextNode;
			}
		}

		return (countedNode+1) == g.vertices;
	}
}