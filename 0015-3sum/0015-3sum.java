class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        if(nums[0] > 0){
            return result;
        }
        int i;
        int n = nums.length;
        for (i=0; i<n-2; i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = n-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum<0){
                    left++;
                }
                else if(sum>0){
                    right --;
                }
                else{
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right --;
                    while(left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }
            }
        }
        return result;
    }
}