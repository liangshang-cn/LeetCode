class Solution {
    List<String> res = new ArrayList<>();
    public List<String> ambiguousCoordinates(String S) {
        if (S == null || S.length() < 1) {
            return res;
        }
        S = S.substring(1, S.length()-1);
        for (int i = 1; i < S.length(); ++i) {
            List<String> left = dfs(S.substring(0, i));
            List<String> right = dfs(S.substring(i, S.length()));
            if (left.size() == 0 || right.size() == 0) {
                continue;
            }
            for (String s1 : left) {
                for (String s2 : right) {
                    String t = "(" + s1 + ", " + s2 + ")";
                    res.add(t);
                }
            }
        }
        return res;
    }
    List<String> dfs(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() == 1) {
            list.add(s);
            return list;
        } else if (s.charAt(0) == '0' && s.charAt(s.length() - 1) == '0') {
            return list;
        } else if (s.charAt(0) == '0') {
            String s1 = s.charAt(0) + "." + s.substring(1);
            list.add(s1);
            return list;
        } else if (s.charAt(s.length() - 1) == '0') {
            list.add(s);
            return list;
        } else {
            int len = s.length();
            for (int i = 1; i < len; ++i) {
                String sub = s.substring(0, i) + "." + s.substring(i, len);
                list.add(sub);
            }
            list.add(s);
            return list;
        }
    }
}
