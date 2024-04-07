class Solution {
    public void solve(int index, int[] arr, int target, List<List<Integer>> answer, List<Integer> list){
        if(index == arr.length){
            if(target == 0){
                answer.add(new ArrayList<>(list));
            }
            return;
        }

        if(arr[index] <= target){
            list.add(arr[index]);
            solve(index, arr, target - arr[index], answer, list);
            list.remove(list.size()-1);
        }
        solve(index+1,arr,target,answer,list);
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        solve(0, candidates, target, answer, list);
        return answer;
    }
}