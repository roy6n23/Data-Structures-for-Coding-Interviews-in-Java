class DeleteEdge{
	public static void remove_edge(Grapg g, int source, int destination){
		g.adjacencyList[source].deleteByValue(destination);
	}
}