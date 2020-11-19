class SortArray{

	public static ArrayList<String> SortArray(String[] arr){
		ArrayList<String> result = new ArrayList<String>();

		Trie trie = new Trie();
		for(int x = 0; x < arr.length; x++)
			trie.insert(arr[x]);

		char[] char_arr = new char[20];
		getWords(trie.getRoot(), result, 0, char_arr);
		return result;

	}

	public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str){
		if(root.isEndWord){
			String temp = "";

			for(int x= 0 ; x < level; x++){
				temp += Character.toString(str[x]);
			}
			result.add(temp);
		}

		for(int i=0; i < 26; i++){
			if(root.children[i] != null){
				str[level] = (char)(i + 'a');
				getWords(root.children[i], result, level+1, str);
			}
		}
	}
}