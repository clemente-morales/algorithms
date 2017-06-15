package add_two_numbers;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(3);

		node1.setNext(node2);
		node2.setNext(node3);

		ListNode n1 = new ListNode(5);
		ListNode n2 = new ListNode(6);
		ListNode n3 = new ListNode(4);

		n1.setNext(n2);
		n2.setNext(n3);

		Solution solution = new Solution();

		ListNode result = solution.addTwoNumbers(node1, n1);

		while (result != null) {
			System.out.print(result.getVal());
			result = result.getNext();
		}

	}

}
