class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // XOR 연산 사용(a ^ a = 0, a ^ 0 = a)
            result = result ^ nums[i];
        }
        
        return result;
    }
}