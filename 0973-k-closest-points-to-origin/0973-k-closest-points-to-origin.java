class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, List<int[]>> map = new TreeMap<>();
        
        for (int[] point : points) {
            int x2 = point[0];
            int y2 = point[1];
            
            double distance = Math.sqrt(Math.pow(x2, 2) + Math.pow(y2, 2));
            
            if (map.containsKey(distance)) {
                map.get(distance).add(point);
            } else {
                ArrayList<int[]> list = new ArrayList<>();
                list.add(point);
                map.put(distance, list);
            }
        }
                                        
        int[][] answer = new int[k][];
        int i = 0;
        
        for (Map.Entry<Double, List<int[]>> entry : map.entrySet()) {
            for (int[] values : entry.getValue()) {
                answer[i++] = values;
                if (i == k) {
                    return answer;
                }
            }
        }
        return answer;
    }
}