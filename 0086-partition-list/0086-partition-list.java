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
        ListNode dummy=new ListNode(-1);
        ListNode curr=dummy;
        ListNode dummy2=new ListNode(-1);
        ListNode curr2=dummy2;

        ListNode temp=head;
        while(temp!=null){
            if(temp.val>=x){
                curr.next=temp;
                curr=curr.next;
            }else{
                curr2.next=temp;
                curr2=curr2.next;
            }
            temp=temp.next;
        }
        curr.next=null;

        curr2.next=dummy.next;

        return dummy2.next;
    }
}