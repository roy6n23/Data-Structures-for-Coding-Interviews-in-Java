class CheckTree {
    public static boolean isTree(Graph g) {
       if(!CheckOneParent(g))
       	return false;

       if(detectCycle(g))
       	return false;

       if(!checkConnected(g, 0))
       	return false

       return true;
    }


    public static boolean
}