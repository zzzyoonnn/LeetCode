class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) return 0;
        
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int depth = 0;
        
        while (!queue.isEmpty()) {
            depth++;
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String s = queue.poll();
                char[] cur = s.toCharArray();
                
                for(int j = 0; j < cur.length; j++) {
                    char ch = cur[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) continue;
                        
                        cur[j] = c;
                        String temp = new String(cur);
                        if (temp.equals(endWord)) return depth + 1;
                        
                        if (set.contains(temp)) {
                            queue.add(temp);
                            set.remove(temp);
                        }
                    }
                    cur[j] = ch;
                }
            }
        }
        return 0;
    }
}