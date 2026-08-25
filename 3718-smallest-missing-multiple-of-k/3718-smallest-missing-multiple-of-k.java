class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101];

        for(int num : nums){
            present[num] = true;
        }

        for(int i=1;;i++){
            int multiple = k*i;
            if(multiple>100 || present[multiple]==false)
                return multiple;
        }
    }
}