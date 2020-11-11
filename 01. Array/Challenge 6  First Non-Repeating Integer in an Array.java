class CheckFirstUnique{
	 public static int findFirstUnique(int[] arr) {

		Map<Integer, Integer> currencyMap = new HashMap<>();
		//将所有元素放进HashMap中，并且配对的是出现的次数
		for( int i = 0; i < arr.length; i++){
			currencyMap.put(arr[i], currencyMap.getOrDefault(arr[i], 0)+1);
		}

		for(int i = 0; i < arr.length; i++){
			if(coutElements.get(arr[i]) <= 1){
				return arr[i];
			} 
		}
		return -1;
	 }

}

// boolean方法


//Returns first unique integer from array
class CheckFirstUnique {
  public static int findFirstUnique(int[] arr) {
    //Inside Inner Loop Check Each index of outerLoop If it's repeated in array
    //If it's not repeated then return this as first unique Integer
    boolean isRepeated = false;
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if (arr[i] == arr[j] && i != j) {
          isRepeated = true;
          break;
        }
      } //end of InnerLoop
      if (isRepeated == false) {
        return arr[i];
      }
      else {
        isRepeated = false;
      }
    
    } //end of OuterLoop
    return - 1;
  }
  public static String arrayToString(int arr[]){
    if (arr.length > 0){
      String result = "";
      for(int i = 0; i < arr.length; i++) {
        result += arr[i] + " ";
      }
      return result;
    }
    else {
      return "Empty Array!";
    }
  }
  public static void  main(String args[]) {
    int[] arr = {2, 54, 7, 2, 6, 54};
    System.out.println("Array: " + arrayToString(arr));
    int unique = findFirstUnique(arr);
    System.out.print("First Unique in an Array: " + unique);
  }
}
