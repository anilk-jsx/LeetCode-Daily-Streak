class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int n = nums.length, i;

        int res  = nums[0] + nums[1] + nums[2];

        for(i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == target){
                    return sum;
                }

                if(Math.abs(sum-target) < Math.abs(res-target)){
                    res = sum;
                }

                if(sum > target){
                    right--;
                }
                else{
                    left++;
                }

                
            }
        }
        return res;
    }
    /*
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        
        // Step 1: Manual Dual-Pivot QuickSort to guarantee O(N log N) without java.util.Arrays
        dualPivotQuickSort(nums, 0, n - 1);
        
        // Initialize with the first valid triplet sum
        int closestSum = nums[0] + nums[1] + nums[2];
        
        // Step 2: Two-pointer processing with aggressive early break boundaries
        for (int i = 0; i < n - 2; i++) {
            // Skip duplicates for the first pointer to avoid redundant calculations
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            int left = i + 1;
            int right = n - 1;
            
            // Optimization A: The smallest possible sum from this anchor point
            int minSum = nums[i] + nums[left] + nums[left + 1];
            if (minSum > target) {
                // If the absolute minimum sum here is greater than target, 
                // it is the closest sum possible from this anchor.
                if (Math.abs(minSum - target) < Math.abs(closestSum - target)) {
                    closestSum = minSum;
                }
                // Since nums is sorted, moving 'i' higher will only make minSum even larger, 
                // so we can stop tracking further loops entirely.
                break; 
            }
            
            // Optimization B: The largest possible sum from this anchor point
            int maxSum = nums[i] + nums[right - 1] + nums[right];
            if (maxSum < target) {
                // If the absolute maximum sum here is less than target,
                // it is the closest sum possible from this anchor.
                if (Math.abs(maxSum - target) < Math.abs(closestSum - target)) {
                    closestSum = maxSum;
                }
                continue; // Moving left pointer up helps, skip inner loop
            }
            
            // Step 3: Inner two-pointer loop
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                // Perfect match exit strategy
                if (currentSum == target) {
                    return currentSum; 
                }
                
                // Update closest sum if current gives a tighter bound
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                if (currentSum < target) {
                    left++;
                    // Fast skip duplicates while climbing
                    while (left < right && nums[left] == nums[left - 1]) left++;
                } else {
                    right--;
                    // Fast skip duplicates while descending
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
            }
        }
        
        return closestSum;
    }
    */
}