package cracking_the_code_interview.cyclic_list;

public class Solution {
	boolean hasCycle(Node head) {
		Node tortoiseNode = head;
		Node hareNode = head;
		
		if (hareNode == null)
			return false;

		while (hareNode != null && hareNode.getNext() != null) {
			tortoiseNode = tortoiseNode.getNext();
			hareNode = hareNode.getNext().getNext();

			if (tortoiseNode == hareNode)
				return true;
		}

		return false;
	}
}
