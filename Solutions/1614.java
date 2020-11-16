class Solution {
    public int maxDepth(String S) {
        if (S == null || S.length() < 1) {
            return 0;
        }
        char[] s = S.toCharArray();
        int res = 0;
        int cur = 0;
        for (int i = 0; i < s.length; ++i) {
            char c = s[i];
            if (c == '(') {
                cur++;
            } else if (c == ')') {
                cur--;         
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
