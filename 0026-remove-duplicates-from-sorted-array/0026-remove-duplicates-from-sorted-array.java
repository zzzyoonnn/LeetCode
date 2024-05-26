import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>(set);
        for (int i = 0; i < set.size(); i++) {
            nums[i] = list.get(i);
        }
        
        
        
        return set.size();
    }
}