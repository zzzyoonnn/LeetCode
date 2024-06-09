import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();    // Key: element, Value: count
        
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int result = 0;
        for (int n : map.keySet()) {
            if (map.get(n) == 1) {
                result = n;
            }
        }
        
        return result;
    }
}