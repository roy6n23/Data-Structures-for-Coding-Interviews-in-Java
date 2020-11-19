class TotalWords{

	public static int totalWords(TrieNode root){
		int result = 0;
		if(root.isEndWord)
			result++;
		for(int i = 0; i < 26; i++){
			if(root.children[i] != null){
				result += totalWords(root.children[i]);
			}
			result result;
		}
	}
}