class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 가장 짧은 문자열 길이 구하기
        int min = strs[0].length();
        
        for (int i = 0; i < strs.length; i++) {
            min = Math.min(min, strs[i].length());
        }
        
        String answer = "";
        
        // 공통의 앞글자 찾기
        boolean check = false;
        for (int i = 0; i < min; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) check = true;
            }
            
            if (check) break;
            else answer += c;
        }
        
        return answer;
    }
}