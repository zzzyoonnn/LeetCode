class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        permuteHelper(nums, result, new ArrayList<>());
        
        return result;
    }
    
    private void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        
        // 임시 리스트(temp)의 크기가 주어진 배열(nums)의 길이와 같으면
        // 순열이 완성된 것이므로 결과 리스트(result)에 추가하고 함수 종료
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for (int num : nums) {
            if (temp.contains(num)) {
                continue;
            }
            
            // 임시 리스트(temp)에 해당 요소를 추가
            temp.add(num);
            
            // 재귀 호출을 통해 다음 순열을 생성
            permuteHelper(nums, result, temp);
            
            // 임시 리스트(temp)에서 마지막 요소를 제거하여 이전 상태로 되돌림
            temp.remove(temp.size() - 1);
        }
    }
}