class Solution {
    public int largestInteger(int[] nums, int k) {
        int maxUniqueNumber = -1;
        int n = nums.length;
        if(k==1){
            HashMap<Integer, Integer> freq = new HashMap<>();
            for(int num : nums){
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
            for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
                if(entry.getValue() == 1)
                    maxUniqueNumber = Math.max(maxUniqueNumber, entry.getKey());
            }
            return maxUniqueNumber; 
        }
        else if(k==n){
            for(int num : nums){
                maxUniqueNumber = Math.max(maxUniqueNumber, num);
            }
            return maxUniqueNumber;
        }
        else{
            return Math.max(checkIfUnique(0, nums), checkIfUnique(n-1, nums));
        }
    }
    int checkIfUnique(int index, int[] nums){
        for(int i=0; i<=nums.length-1; i++){
            if(i!=index && nums[i]==nums[index]){
                return -1;
            }
        }
        return nums[index];
    }
}