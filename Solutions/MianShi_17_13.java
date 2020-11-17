// 思路1 ： dp
//时间复杂度为O(n^2)
class Solution {
    public int respace(String[] dictionary, String sentence) {
        if (sentence == null || sentence.length() < 1) {
            return 0;
        }
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        // f[x]表示处理前x个字符的最少未识别字符数
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i-1] + 1;
            for (int j = 0; j < i; ++j) {
                if (dict.contains(sentence.substring(j, i))) {
                    f[i] = Math.min(f[i], f[j]);
                }
            }
        }
        return f[n];
    }
}

// 思路2：dp + Trie
// 最坏情况下时间复杂度为O(n^2)
class Solution {
    public int respace(String[] dictionary, String sentence) {
        if (sentence == null || sentence.length() < 1) {
            return 0;
        }
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }
        int n = sentence.length();
        // f[x]表示处理前x个字符的最少未识别字符数
        int[] f = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            f[i] = f[i-1] + 1;
            for (int idx : trie.search(sentence, i - 1)) {
                f[i] = Math.min(f[i], f[idx]);
            }
        }
        return f[n];
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    void insert(String word) {
        TrieNode cur = root;
        for (int i = word.length() - 1; i >= 0; --i) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode();
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }
    //这个函数对思路1进行了优化，返回文本中以指定字符结尾的所有单词的起始坐标
    List<Integer> search(String sentence, int end) {
        List<Integer> index = new ArrayList<>();
        TrieNode cur = root;
        for (int i = end; i >= 0; --i) {
            int c = sentence.charAt(i) - 'a';
            if (cur.children[c] == null) {
                break;
            }
            cur = cur.children[c];
            if (cur.isWord) {
                index.add(i);
            }
        }
        return index; 
    }
}

class TrieNode {
    boolean isWord;
    TrieNode[] children = new TrieNode[26];
}
