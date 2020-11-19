// 思路1：如果异位词全部由小写字母组成，可以用一个容量为26的数组来统计字母出现频率。时间复杂度O(n)，空间复杂度O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            cnt[s.charAt(i) - 'a'] ++;
            cnt[t.charAt(i) - 'a'] --;
        }
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
// 思路2：直接排序然后比较即可 时间复杂度O(nlogn)，空间复杂度O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        for (int i = 0; i < ss.length; ++i) {
            if (ss[i] != tt[i]) {
                return false;
            }
        }
        return true;
    }
}
