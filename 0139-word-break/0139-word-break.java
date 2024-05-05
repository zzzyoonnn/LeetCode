class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] check = new boolean[s.length()];
        
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || check[j - 1]) {       // j가 0이거나 j-1까지의 부분 문자열이 wordDict에 존재하는 경우
                    if (wordDict.contains(s.substring(j, i + 1))) {
                        check[i] = true;        // 해당 부분 문자열이 단어로 나눌 수 있는 경우, check[i] = true;
                        break;
                    }
                }
            }
        }
        
        // 문자열 s 전체가 단어 사전 wordDict를 사용하여 나눌 수 있는지 여부를 반환
        return check[check.length - 1];
    }
}