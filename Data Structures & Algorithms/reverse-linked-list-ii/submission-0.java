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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = new ListNode(-1);
        ListNode dummy=prev;
        prev.next=head;
        int start=left;
        while(left>1){
            prev=curr;
            curr=curr.next;
            left--;
        }
        prev.next=reverse(curr,start,right);

        return dummy.next;
    }

    private ListNode reverse(ListNode head , int left,int right) {
        ListNode prev=null;
        ListNode curr=head;
        ListNode tail=head;
        ListNode next = curr;
        while(right-left>=0) {
          left++;
          //System.out.println("Curr  : " + curr.val);
          next = curr.next;
          curr.next=prev;
          prev=curr;
          curr=next;
        }
        tail.next=next;
        return prev;
    }
}