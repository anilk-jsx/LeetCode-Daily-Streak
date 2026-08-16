class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for(int stone: stones){
            count[stone%3]++;
        }

        if (count[0] % 2 == 0) {
            // Alice must be able to start with either a 1 or 2
            // and eventually force Bob onto sum % 3 == 0.
            return Math.min(count[1], count[2]) > 0;
        }
        
        // An odd number of remainder-0 stones flips the winner.
        // Alice needs one remainder class to dominate sufficiently.
        return Math.abs(count[1] - count[2]) > 2;
    }
}