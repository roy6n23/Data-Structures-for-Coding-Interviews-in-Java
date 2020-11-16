class CheckCycle {
    public static boolean detectCycle(Graph g){
        int num_of_vertices = g.vertices;

        //Boolean Array to hold the history of visited nodes (by default-false)
        boolean[] visited = new boolean [num_of_vertices];
        //Holds a flag if the node is currently in Stack or not (by default- false)
        boolean[] stackFlag = new boolean[num_of_vertices];

        for (int i = 0; i < num_of_vertices; i++){
            //Check cyclic on each node
            if (cyclic(g, i, visited, stackFlag)){
                return true;
            }
        }
        return false;
    }
    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag){
        
        // base case
        // if the node has been visited, that means there are no cycles
        //if node is currently in stack that means we have found a cycle
        if (stackFlag[v])
            return true;

        //if it is already visited (and not in Stack) then there is no cycle
        // if we're on a current path and we come across a node that is currently being explore, there's a cycle
        if (visited[v])
            return false;

        visited[v] = true;
        stackFlag[v] = true;

        // check adjacency list of the node
        DoublyLinkedList<Integer>.Node temp = null;
        if (g.adjacencyList[v] != null)
            temp = g.adjacencyList[v].headNode;

        while (temp != null) {
            //run cyclic function recursively on each outgowing path
            if(cyclic(g, temp.data, visited, stackFlag)){
                return true;
            }
            temp = temp.nextNode;
        }
        //if we break out here, then we have not found a cycle on any path from this node
        stackFlag[v] = false;

        return false;
    }
    public static void main(String args[]) {
        Graph g1 = new Graph(4);
        g1.addEdge(0,1);
        g1.addEdge(1,2);
        g1.addEdge(1,3);
        g1.addEdge(3,0);
        g1.printGraph();
        System.out.println(detectCycle(g1));

        System.out.println();
        Graph g2 = new Graph(3);
        g2.addEdge(0,1);
        g2.addEdge(1,2);
        g2.printGraph();
        System.out.println(detectCycle(g2));
  }
}


//==========exprimental===============
class CheckCycle{
    public static boolean detectCycle(Graph g){
        int num_of_vertices = g.vertices;

        boolean[] visited = new boolean[num_of_vertices];
        boolean[] stackFlag = new boolean[num_of_vertices];


        for(int i = 0; i < num_of_vertices; i++){
            if(cyclic(g, i, visited, stackFlag))
                return true;
        }

        return false;
    }

    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag){
        if(stackFlag[v])
            return true;
        if(visited[v])
            return false;

        visited[v] = true;
        stackFlag[v] = true;

        DoublyLinkedList<Integer>.Node temp = null;
        if(g.adjacencyList[v] != null)
            temp = g.adjacencyList[v].headNode;

        while(temp != null){
            if(cyclic(g, temp.data, visited, stackFlag))
                return true;
            temp = temp.nextNode;
        }

        stackFlag[v] = false;

        return false;

    }
}