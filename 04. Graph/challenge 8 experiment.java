class CheckMin{
	public static int findMin(Graph g, int source, int destination){
		if(source == destination)
			return 0;

		int result = 0;
		int num_of_vertices = g.vertices;

		boolean[] visited = new boolean[num_of_vertices];

		int[] distance = new boolean[num_of_vertices];

		Queue<Integer> queue = new Queue<>(num_of_vertices);

		queue.enqueue(source);
		visited[source] = true;

		while(!queue.isEmpty()){

			int currentNode = queue.dequeue();

			DoulyLinkedList<Integer>.Node tmp = null;
			if(g.adjacencyList[currentNode] != null){
				tmp = g.adjacencyList[currentNode].headNode;
			}

			while(tmp != null){
				if(!visited[tmp]){
					queue.enqueue(tmp.data);
					visited[tmp.data] = true;
					distance[tmp.data] = distance[currentNode] + 1;
				}
				if(tmp.data == destination)
					return distance[tmp.data];
				tmp = tmp.nextNode;
			}
		}

		return -1;
	}
}