package Tries;

public class TrieNode {

    char data;
    boolean isTerminal;
    TrieNode children[];
    int childCount;

    public TrieNode(char data){
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
        this.childCount = 0;
    }
}
