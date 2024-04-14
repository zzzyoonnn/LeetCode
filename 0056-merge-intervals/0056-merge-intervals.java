class Solution {
    public int[][] merge(int[][] intervals) {
        
        ArrayList<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);      // intervals배열 정렬
        
        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        
        for (int[] interval : intervals) {
            int curStart = interval[0];
            int curEnd = interval[1];
            
            if (curStart <= preEnd) {       // 겹치는 구간 업데이트
                preStart = Math.min(curStart, preStart);
                preEnd = Math.max(curEnd, preEnd);
            } else {        // 겹치는 구간이 없다면, 기존 구간 추가 후, 새로운 구간 업데이트
                answer.add(new int[]{preStart, preEnd});
                
                preStart = curStart;
                preEnd = curEnd;
            }
        }
        
        answer.add(new int[]{preStart, preEnd});    // 마지막 구간 추가
        return answer.toArray(new int[0][]);
        
    }
}