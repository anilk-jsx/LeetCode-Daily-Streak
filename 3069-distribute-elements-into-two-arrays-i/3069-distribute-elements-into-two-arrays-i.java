class Solution {
    public int[] resultArray(int[] nums) {
        
        int n  = nums.length;
        int[] first = new int[n];
        int[] second = new int[n];

        first[0] = nums[0];
        second[0] = nums[1];

        int flast = 0;
        int slast = 0;

        for(int i=2; i<n; i++){
            if(first[flast] > second[slast]){
                first[++flast] = nums[i];
            }
            else{
                second[++slast] = nums[i];
            }
        } 
        for(int i=0; i<=slast; i++){
            first[++flast] = second[i];
        }
        return first;
    }
}