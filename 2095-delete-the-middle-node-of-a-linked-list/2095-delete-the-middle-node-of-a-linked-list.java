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
    public ListNode deleteMiddle(ListNode head) {
        // use fast and slow pointers. Move fast pointer by 2, and slow pointer by one indices after checking the fast pointer. When fast.next equals null or fast equals null, make slow point to the the next next value.
        //n = 1 case
        if (head.next == null) {
            return null;
        }
        
        ListNode fast = head.next.next;
        ListNode slow = head;
    
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        
        return head;
    }
}