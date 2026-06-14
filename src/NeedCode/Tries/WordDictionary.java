package NeedCode.Tries;

public class WordDictionary {
    WordDictionary[] children;
    boolean isEndOfWord;

    public WordDictionary() {
        this.children = new WordDictionary[26];
        this.isEndOfWord = false;
    }

    public void addWord(String word) {
        WordDictionary current = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new WordDictionary();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, this);
    }

    private boolean dfs(String word, int index, WordDictionary current) {
        if (index == word.length()) {
            return current.isEndOfWord;
        }
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < current.children.length; i++) {
                if (current.children[i] != null) {
                    if (dfs(word, index + 1, current.children[i])) {
                        return true;
                    }
                }
            }
            return false;
        }
        int alphabetIndex = c - 'a';
        if (current.children[alphabetIndex] != null) {
            return dfs(word, index + 1, current.children[alphabetIndex]);
        }
        return false;
    }
}
