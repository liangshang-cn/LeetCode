class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        char[] c = s.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; ++i) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                c[i] = (char)(c[i] + 32);
            }
        }
        int i = 0, j = len - 1;
        while (i < j) {
            while (i < j && !isDight(c[i]) && !isAlpha(c[i])) {
                i++;
            }
            while (j > i && !isDight(c[j]) && !isAlpha(c[j])) {
                j--;
            }
            if (c[i] != c[j]) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
    private boolean isDight(char c) {
        return c >= '0' && c <= '9';
    }
    private boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'); 
    }
}
