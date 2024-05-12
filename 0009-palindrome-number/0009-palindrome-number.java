class Solution {
    public boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder();
        
        sb.append(x);
        String original = sb.toString();
        
        sb = sb.reverse();
        String reverse = sb.toString();
        
        return original.equals(reverse);
    }
}