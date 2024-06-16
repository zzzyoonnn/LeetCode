class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) list.add(i);
        
        for (int i : nums) {
            list.remove(Integer.valueOf(i));
        }
        
        return list.get(0);
    }
}