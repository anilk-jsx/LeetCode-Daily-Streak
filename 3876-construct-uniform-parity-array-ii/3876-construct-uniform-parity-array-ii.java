class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int minOdd = Integer.MAX_VALUE;

        for(int num : nums1){
            if(num%2 == 1 && num<minOdd){
                minOdd = num;
            }
        }
        for(int num : nums1){
            if(minOdd != Integer.MAX_VALUE && num%2==0 && num<minOdd){
                return false;
            }
        }
        return true;
    }
}