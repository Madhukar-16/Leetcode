class Solution {
    public String removeOuterParentheses(String s) {

        int n = s.length();
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            char ch = s.charAt(i);

            if (st.isEmpty() && ch == '(') {
                st.push(ch);
            } 
            else if (!st.isEmpty()) {

                if (ch == ')') {
                    st.pop();
                }

                if (!st.isEmpty()) {
                    sb.append(ch);
                }

                if (ch == '(') {
                    st.push(ch);
                }
            }
        }

        return sb.toString();
    }
}