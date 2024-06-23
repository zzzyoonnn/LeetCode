import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();    // Key: num, Value: index
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            
            if (map.containsKey(n)) {
                if (Math.abs(map.get(n) - i) <= k) return true;
            }
            
            map.put(n, i);
        }
        
        return false;
    }
}