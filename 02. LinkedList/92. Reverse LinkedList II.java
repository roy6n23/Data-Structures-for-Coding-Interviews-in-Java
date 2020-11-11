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
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	//corner case
    	if(m == n)
    		return head;
    	if(head == null)
    		return null;

        ListNode prevNode = null;
        ListNode currNode = head;
        ListNode nextNode = null;

        for(int i = 0; currNode != null && i < m-1; i++){
        	prevNode = currNode;
        	currNode = currNode.next;
        }
        //前一片段的最后一个节点，和翻转后最前的节点连接
        ListNode prepreNode = prevNode;

        //刚开始时的最前面的节点，反转后变成最后的节点
        ListNode precurNode = currNode;

        for(int i = 0; currNode != null && i < n - m +1; i++){
        	
        	nextNode = currNode.next;
        	currNode.next = prevNode;
        	prevNode = currNode;
        	currNode = nextNode;
        	
        }

        corner case
        if(prepreNode != null)
            prepreNode.next = prevNode;
        else
            head = prevNode;
       
        precurNode.next = currNode;

        return head;
    }
}