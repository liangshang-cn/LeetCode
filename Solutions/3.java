# 无重复数组的最长子串 双指针维护一个窗口 时间复杂度O(n) 空间复杂度O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(c[i])) {
                left = Math.max(left, map.get(c[i]) + 1);
            }
            map.put(c[i], i);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
