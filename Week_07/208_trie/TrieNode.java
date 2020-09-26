public class TrieNode {
    private boolean isEnd;

    private TrieNode[] next;

    public TrieNode() {
        next = new TrieNode[26];
    }

    public boolean containChar(char c) {
        return next[c - 'a'] != null;
    }

    public void putNextNodeAtChar(char c, TrieNode newNode) {
        next[c - 'a'] = newNode;
    }

    public TrieNode getNextNodeAtChar(char c) {
        return next[c - 'a'];
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
