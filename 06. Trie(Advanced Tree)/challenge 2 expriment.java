class FindWords{

	public static ArrayList<String> findWords(TrieNode root){
		ArrayList<String> result = new ArrayList<String>();
		char[] chararr = new char[20];
		getWords(root, result, 0, chararr);
		return result;
	}

	public static void getWords(TrieNode root, ArrayList<String> result, int level, char[] str){
		if(root.isEndWord){

			String temp = "";

			for(int x = 0; x < level; x++){
				temp += Character.toString(str[x]);
			}
			result.add(temp);
		}

		for(int i = 0 ; i < 26; i++){
			if(root.children[i] != null){
				str[level] = (char)(i + 'a');
				getWords(root.children[i], result, level +1, str)
			}
		}
	}
}