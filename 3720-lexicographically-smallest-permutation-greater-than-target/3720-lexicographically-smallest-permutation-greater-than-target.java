class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];

        // Count characters in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        char[] t = target.toCharArray();

        // Try to make target larger from right to left
        for (int i = t.length - 1; i >= 0; i--) {
            int current = t[i] - 'a';

            // Return characters used by target[0...i-1]
            int[] remaining = freq.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int idx = t[j] - 'a';

                if (remaining[idx] == 0) {
                    possible = false;
                    break;
                }

                remaining[idx]--;
            }

            if (!possible) {
                continue;
            }

            // Find the smallest character > target[i]
            for (int c = current + 1; c < 26; c++) {
                if (remaining[c] > 0) {

                    StringBuilder ans = new StringBuilder();

                    // Prefix remains unchanged
                    for (int j = 0; j < i; j++) {
                        ans.append(t[j]);
                    }

                    // Increase current position
                    ans.append((char) ('a' + c));
                    remaining[c]--;

                    // Append remaining characters in sorted order
                    for (int x = 0; x < 26; x++) {
                        while (remaining[x] > 0) {
                            ans.append((char) ('a' + x));
                            remaining[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}