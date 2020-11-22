// 后缀表达式求值
class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stk = new LinkedList<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (int i = 0; i < tokens.length; ++i) {
            String token = tokens[i];
            if (!set.contains(token)) {
                stk.push(Integer.parseInt(token));
            } else {
                int val1 = stk.pop();
                int val2 = stk.pop();
                if (token.equals("+")) {
                    stk.push(val1 + val2);
                } else if (token.equals("-")) {
                    stk.push(val2 - val1);
                } else if (token.equals("*")) {
                    stk.push(val2 * val1);
                } else {
                    stk.push(val2 / val1);
                }
            }
        }
        return stk.pop();
    }
}
