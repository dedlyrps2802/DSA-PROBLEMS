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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy =  new ListNode(0);
        ListNode current = dummy;

        ListNode temp1 = head;
        ListNode temp2 = head;

        while(temp1!=null){
            if(temp1.val < x){
                current.next =  new ListNode(temp1.val);
                current = current.next;
            }
            temp1 = temp1.next;
        }

        while(temp2!=null){
            if(temp2.val >= x){
                current.next = new ListNode(temp2.val);
                current = current.next;
            }
            temp2 = temp2.next;
        }

        return dummy.next; 
    }
}