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
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;
        ListNode current = head;

        while(current!= null  && current.next != null){
            ListNode first = current;
            ListNode second = current.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;

            prev = first;
            current = first.next;
            
        }

       
        

        return dummy.next;
    }
}