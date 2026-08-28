class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        
    int n = s.length();
        int half = n / 2;

        int[] freq = new int[26];

        // Count characters.
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // A palindrome can have at most ONE odd-frequency character.
        int oddCount = 0;
        int middle = -1;

        for (int c = 0; c < 26; c++) {

            if ((freq[c] & 1) == 1) {
                oddCount++;
                middle = c;
            }
        }

        // No palindromic permutation is possible.
        if (oddCount > 1) {
            return "";
        }

        // Convert frequencies into counts for the first half.
        int[] halfCount = new int[26];

        for (int c = 0; c < 26; c++) {
            halfCount[c] = freq[c] / 2;
        }

        /*
         * Candidate 1:
         * Keep target's first half exactly the same.
         */
        String answer = "";

        if (canBuildHalf(halfCount, target, half)) {

            String firstHalf = target.substring(0, half);

            String candidate = buildPalindrome(firstHalf, middle);

            if (candidate.compareTo(target) > 0) {
                answer = candidate;
            }
        }

        /*
         * Candidate 2:
         * Make the first half greater than target's first half.
         *
         * We choose the RIGHTMOST possible position to increase.
         */
        int[] remaining = halfCount.clone();

        int bestPivot = -1;
        int bestChar = -1;

        for (int i = 0; i < half; i++) {

            int targetChar = target.charAt(i) - 'a';

            // Find smallest available character > target[i].
            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] > 0) {
                    bestPivot = i;
                    bestChar = c;
                    break;
                }
            }

            // Cannot continue matching target.
            if (remaining[targetChar] == 0) {
                break;
            }

            remaining[targetChar]--;
        }

        /*
         * Build candidate using the best pivot.
         */
        if (bestPivot != -1) {

            int[] leftCount = halfCount.clone();

            // Use target prefix before pivot.
            for (int i = 0; i < bestPivot; i++) {
                leftCount[target.charAt(i) - 'a']--;
            }

            // Use the greater pivot character.
            leftCount[bestChar]--;

            StringBuilder firstHalf = new StringBuilder();

            // Target prefix.
            for (int i = 0; i < bestPivot; i++) {
                firstHalf.append(target.charAt(i));
            }

            // Greater pivot.
            firstHalf.append((char) ('a' + bestChar));

            // Smallest possible suffix.
            for (int c = 0; c < 26; c++) {

                while (leftCount[c] > 0) {
                    firstHalf.append((char) ('a' + c));
                    leftCount[c]--;
                }
            }

            String candidate =
                    buildPalindrome(firstHalf.toString(), middle);

            // Keep the smaller valid candidate.
            if (answer.isEmpty() ||
                candidate.compareTo(answer) < 0) {

                answer = candidate;
            }
        }

        return answer;
    }

    /*
     * Checks whether target[0 ... half-1]
     * can be formed using the available characters.
     */
    private boolean canBuildHalf(
            int[] halfCount,
            String target,
            int half) {

        int[] temp = halfCount.clone();

        for (int i = 0; i < half; i++) {

            int c = target.charAt(i) - 'a';

            if (temp[c] == 0) {
                return false;
            }

            temp[c]--;
        }

        return true;
    }

    /*
     * firstHalf + middle + reverse(firstHalf)
     */
    private String buildPalindrome(
            String firstHalf,
            int middle) {

        StringBuilder result = new StringBuilder();

        result.append(firstHalf);

        if (middle != -1) {
            result.append((char) ('a' + middle));
        }

        result.append(
            new StringBuilder(firstHalf).reverse()
        );

        return result.toString();
    }
}