//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();  
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();  
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckSubset {
  public static boolean isSubset(int[] arr1, int[] arr2) {
    HashSet<Integer> hset = new HashSet<>();

    for(int i = 0; i <arr1.length; i++){
    	if(!hset.contains(arr1[i]))
    		hset.add(arr[i]);
    }

    for( int i = 0; i < arr2.length; i++){
    	if(!hset.contains(arr2[i]))
    		return false;
    }
    return true;
  }

  
  public static void main(String args[]) {
    
    int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
    int[] arr2 = {7, 1, -2};
    int[] arr3 = {10, 12};

    System.out.println(isSubset(arr1, arr2));
    System.out.println(isSubset(arr1, arr3));
  }
}