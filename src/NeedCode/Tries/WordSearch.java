package NeedCode.Tries;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int r = 0; r < board.length; r++){
            for( int c = 0; c < board[0].length; c++){
                dfs(board, r, c, root, result);
            }
        }
        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode node = root;
            for (char ch : w.toCharArray()) {
                int chIndex = ch - 'a';
                if (node.children[chIndex] == null) {
                    node.children[chIndex] = new TrieNode();
                }

                node = node.children[chIndex];
            }
            node.word = w;
        }
        return root;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        if(r < 0 || c <0 || r >= board.length || c >= board[0].length){
            return;
        }

        char ch = board[r][c];
        if (ch == '#') return;

        TrieNode child = node.children[ch - 'a'];
        if (child == null) return;

        if (child.word != null) {
            result.add(child.word);
            child.word = null;
        }

        // ================= Backtracking =================
        board[r][c] = '#';

        dfs(board, r + 1, c, child, result);
        dfs(board, r - 1, c, child, result);
        dfs(board, r, c + 1, child, result);
        dfs(board, r, c - 1, child, result);

        board[r][c] = ch;
    }
}
