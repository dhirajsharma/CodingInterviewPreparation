public class Trie{

	static TrieNode createTrie(){
		return(new TrieNode('\0', false));
	}

	static void insertWord(TrieNode root, String word){
		int offSet = 97;
		int length = word.length();
		char [] letters = word.toCharArray();
		TrieNode curNode = root;

		for (int i = 0; i < length; i++) {
			//System.out.println(letters[i]+" "+(letters[i]-offSet));
			if (curNode.node[letters[i]-offSet] == null) {
				curNode.node[letters[i]-offSet] = new TrieNode(letters[i], i == length-1? true:false);
				curNode = curNode.node[letters[i]-offSet];
			}
		}
	}

	static void printTree(TrieNode root, int level, char[] branch){
		if (root == null) {
			return;
		}

		for (int i = 0; i < root.node.length; i++) {
			branch[level] = root.character;
			printTree(root.node[i], level+1, branch);
		}

		if (root.isWord) {
			for (int j = 1; j <= level; j++) {
				System.out.println(branch[j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		String words[] = {"dhiraj", "dhishat", "prayank", "swetha", "dhara", "sumukha"};

		TrieNode trieNode = createTrie();
		//System.out.println(words.length);
		for (int i = 0; i < words.length; i++) {
			//System.out.println(words[i]+" "+i);
			insertWord(trieNode, words[i]);
		}

		char[] branch = new char[50];
		printTree(trieNode, 0, branch);
	}
}

class TrieNode{
	char character;
	TrieNode[] node;
	boolean isWord;

	TrieNode(char character, boolean isWord){
		this.character = character;
		node = new TrieNode[26];
		this.isWord = isWord;
	}
}