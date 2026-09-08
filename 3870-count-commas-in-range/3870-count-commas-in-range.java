class Solution {
    public int countCommas(int n) {
        int ans = 0;
        long start = 1000;
        long commas = 1;

        while (start <= n) {
            long end = Math.min((long) n, start * 1000 - 1);

            ans += (end - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return ans;
    }
}