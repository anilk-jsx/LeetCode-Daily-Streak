class Solution {
    public int minimumDeletions(int[] nums) {

        int n = nums.length;

        if(n == 1){
            return 1;
        }

        int minIndex = 0;
        int maxIndex = 0;

        for(int i=1; i<n; i++){
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
        }
        
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        return Math.min(right+1, Math.min(n-left, left+1+n-right));
    }
}