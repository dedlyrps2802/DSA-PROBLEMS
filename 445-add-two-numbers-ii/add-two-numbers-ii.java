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

 import java.math.BigInteger;
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        

        BigInteger num1 = ListtoBigInteger(l1);
        BigInteger num2 = ListtoBigInteger(l2);
        BigInteger sum = num1.add(num2);

        return bigintegertolist(sum);
    }

   private BigInteger ListtoBigInteger(ListNode l1){
        StringBuilder sb = new StringBuilder();

        while(l1!= null){
            sb.append(l1.val);
            l1 = l1.next;
        }
        return new BigInteger(sb.toString());
    }
    private ListNode bigintegertolist(BigInteger num) {
    String str = num.toString();
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    
    for (int i = 0; i < str.length(); i++) {
        int digit = Character.getNumericValue(str.charAt(i));
        current.next = new ListNode(digit);
        current = current.next;
    }
    return dummy.next;
}
}