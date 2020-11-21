// 单词接龙
import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        queue.add(beginWord);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; ++j) {
                String word = queue.poll();
                char[] str = word.toCharArray();
                for (int i = 0; i < str.length; ++i) {
                    char old = str[i];
                    for (char c = 'a'; c <= 'z'; ++c) {
                        str[i] = c;
                        String temp = String.valueOf(str);
                        if (dict.contains(temp)) {
                            if (temp.equals(endWord)) {
                                return step + 1;
                            }
                            if (!visited.contains(temp)) {
                                queue.add(temp);
                                visited.add(temp);
                            }
                        }
                    }
                    str[i] = old;
                }
            }
            step++;
        }
        return 0;
    }
}
