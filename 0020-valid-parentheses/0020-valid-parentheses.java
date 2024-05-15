class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            stack.add(c); 
            if (c == ')') {
                stack.pop();
                if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                else return false;
            }

            if (c == ']') {
                stack.pop();
                if (!stack.isEmpty() && stack.peek() == '[') stack.pop();
                else return false;
            }

            if (c == '}') {
                stack.pop();
                if (!stack.isEmpty() && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        
        if (stack.size() == 0) return true;
        else return false;
    }
}