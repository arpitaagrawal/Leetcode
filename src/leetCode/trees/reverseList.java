package leetCode.trees;

public class reverseList {

	public static ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		else {
			ListNode prevNode = head;
			ListNode curNode = head.next;
			prevNode.next = null;
			ListNode nextNode = curNode.next;
			while (curNode != null) {
				curNode.next = prevNode;
				prevNode = curNode;
				curNode = nextNode;
				if (nextNode != null) {
					nextNode = nextNode.next;
				}
			}
			return prevNode;
		}

	}
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(3);
		node1.next.next = new ListNode(4);
		reverseList(node1);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
