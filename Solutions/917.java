class Solution {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() < 2) {
            return S;
        }
        char[] s = S.toCharArray();
        int i = 0, j = s.length - 1;
        while (i < j) {
            if (!isAlpha(s[i])) {
                i++;
            } else if (!isAlpha(s[j])) {
                j--;
            } else {
                char t = s[i]; s[i] = s[j]; s[j] = t;
                i++; j--;
            }
        }
        return new String(s);
    }
    private boolean isAlpha(char t) {
        return (t >= 'a' && t <= 'z') || (t >= 'A' && t <= 'Z');
    }
}
