import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> val = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {

            String ch = tokens[i];

            if (!ch.equals("+") && !ch.equals("-") &&
                !ch.equals("*") && !ch.equals("/")) {

                val.push(Integer.parseInt(ch));
            }
            else {
                int v2 = val.pop();
                int v1 = val.pop();

                if (ch.equals("+"))
                    val.push(v1 + v2);

                if (ch.equals("-"))
                    val.push(v1 - v2);

                if (ch.equals("*"))
                    val.push(v1 * v2);

                if (ch.equals("/"))
                    val.push(v1 / v2);
            }
        }

        return val.peek();
    }
}