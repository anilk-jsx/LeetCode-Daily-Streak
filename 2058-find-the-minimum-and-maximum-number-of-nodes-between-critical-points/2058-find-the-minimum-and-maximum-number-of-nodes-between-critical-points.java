/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
    int minDistance = Integer.MAX_VALUE;
        int maxDistance = 0;

        // Previous node and current node
        ListNode prev = head;
        ListNode curr = head.next;

        // Position of current node
        int pos = 1;

        // First and previous critical point positions
        int firstCritical = -1;
        int prevCritical = -1;

        while (curr != null && curr.next != null) {

            // Check if curr is a local maximum or minimum
            boolean isCritical =
                    (curr.val > prev.val && curr.val > curr.next.val) ||
                    (curr.val < prev.val && curr.val < curr.next.val);

            if (isCritical) {

                // First critical point
                if (firstCritical == -1) {
                    firstCritical = pos;
                } else {
                    // Distance from previous critical point
                    minDistance = Math.min(
                        minDistance,
                        pos - prevCritical
                    );

                    // Distance from first critical point
                    maxDistance = pos - firstCritical;
                }

                prevCritical = pos;
            }

            prev = curr;
            curr = curr.next;
            pos++;
        }

        // Fewer than 2 critical points
        if (firstCritical == -1 || firstCritical == prevCritical) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}