/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node temp = head;

       

        while(temp!=null){
             Node current = new Node(temp.val);
              current.next = temp.next;
             temp.next = current;
             temp = current.next;
        }

        temp = head;
        while(temp!=null){
            if(temp.random!=null){
            temp.next.random = temp.random.next;
            }
            temp = temp.next.next;

        
        }

        temp = head;
        Node newhead1 = head.next;
        Node currnew = newhead1;

        while(temp!=null){
            temp.next = currnew.next;
            temp = temp.next;
            if(temp!=null){
            currnew.next = temp.next;
            currnew = currnew.next;
        } 
        }

        return newhead1;
    }
}