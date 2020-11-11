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
    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null;
        ListNode currentNode = head.headNode;
        ListNode nextNode = null;

        while(currentNode != null){
        	nextNode = currentNode.next;
        	currentNode.next = previousNode;
        	previousNode = currentNode;
        	currentNode = nextNode;
        }

        return previousNode;
    }
}


//================Recursively

public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode p = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return p;
}

