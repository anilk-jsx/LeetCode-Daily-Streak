class Solution {
    public int longestSubsequence(int[] nums) {
        
        int n = nums.length;
        int xor;
        int count = xor = 0;

        for(int x : nums){
            xor ^= x;
            if(x == 0){
                count++;
            }
        }
        if(xor != 0){
            return n;
        }
        else if(count == n){
            return 0;
        }
        else{
            return n-1;
        }
    }
}