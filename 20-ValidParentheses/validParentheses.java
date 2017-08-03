/*
*   Given a string containing just the characters (){}[],determine if the input string is valid.
*   The brackets must close in the correct order.
*/

public class Solution {
    public boolean validParentheses(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curt = s.charAt(i);
            if (curt == ']' || curt == '}' || curt == ')') {
                if (stack.empty()) return false;
                char tmp = stack.pop();
                switch (curt) {
                    case ']': if (tmp != '[') return false;
                              break;
                    case '}': if (tmp != '{') return false;
                              break;
                    case ')': if (tmp != '(') return false;
                              break;
                    default: return false;      // 当字符串包含除{}[]()之外的字符串时返回false
                }
            } else {
                stack.push(curt);   
            }
        }
        if (!stack.empty()) return false;
        return true;
    }
}
