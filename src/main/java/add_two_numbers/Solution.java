package add_two_numbers;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		// ListNode result = addTwoNumbers(l1, l2, null, 0);
		
		ListNode result = null;
		ListNode resultHead = null;

		int rest = 0;
		
		while (l1 != null && l2 != null) {
			int product = rest;

			if (l1 != null) {
				product += l1.getVal();
				l1 = l1.getNext();
			}

			if (l2 != null) {
				product += l2.getVal();
				l2 = l2.getNext();
			}

			if (result == null) {
				result = new ListNode(product % 10);
				resultHead = result;
				rest = product / 10;
			} else {
				result.setNext(new ListNode(product % 10));
				result = result.getNext();
				rest = product / 10;
			}
		}
		
		
		return resultHead;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2, ListNode result, int rest) {
		if (l1 == null && l2 == null)
			return result;

		int product = rest;

		ListNode nextL1 = null;
		ListNode nextL2 = null;

		if (l1 != null) {
			product += l1.getVal();
			nextL1 = l1.getNext();
		}

		if (l2 != null) {
			product += l2.getVal();
			nextL2 = l2.getNext();
		}

		if (result == null) {
			result = new ListNode(product % 10);
			return addTwoNumbers(nextL1, nextL2, result, product / 10);
		} else {
			result.setNext(new ListNode(product % 10));
			return addTwoNumbers(nextL1, nextL2, result.getNext(), product / 10);
		}

	}
}
