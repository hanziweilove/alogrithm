package tree;

/**
 * Created by ziweihan on 7/23/19.
 *
 * 208. Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.

 Example:

 Trie trie = new Trie();

 trie.insert("apple");
 trie.search("apple");   // returns true
 trie.search("app");     // returns false
 trie.startsWith("app"); // returns true
 trie.insert("app");
 trie.search("app");     // returns true
 Note:

 You may assume that all inputs are consist of lowercase letters a-z.
 All inputs are guaranteed to be non-empty strings.
 */
public class Trie_M {

    /** Initialize your data structure here. */
    private TrieNode root;
    public Trie_M() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i< word.length(); i++){
            char c = word.charAt(i);
            if(!cur.containsKey(c)){
                cur.setChild(c);
            }
            cur = cur.getChild(c);
        }
        cur.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i<word.length(); i++){
            char c = word.charAt(i);
            if(!cur.containsKey(c)){
                return false;
            }
            cur = cur.getChild(c);
        }
        return cur.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.containsKey(c)){
                return false;
            }
            cur = cur.getChild(c);
        }
        return cur!=null;
    }


    public static void main(String[] args){
        Trie_M trie = new Trie_M();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    }
}


class TrieNode{
    TrieNode[] links;
    boolean isEnd;
    int size = 26;
    public TrieNode(){
        links = new TrieNode[size];
    }

    public boolean containsKey(char c){
        return links[c-'a']!=null;
    }

    public TrieNode getChild(char c){
        return links[c-'a'];
    }

    public void setChild(char c){
        links[c-'a'] = new TrieNode();
    }
}

