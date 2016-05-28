public class AddNumbersLinkedList {
	public static void main(String[] args) {
		AddNumbersLinkedList solution = new AddNumbersLinkedList();
		int[] firstNumber  = {9,8,9,7,6}; // number: 98976
        int[] secondNumber = {1,9,8}; // number: 198
         
        // 9->8->9->7->6->null
        ListNode head1 = solution.createLinkedList(firstNumber);
         
        // 1->9->8->null
        ListNode head2 = solution.createLinkedList(secondNumber);
         
        ListNode result = solution.addLists(head1, head2);
         
        System.out.print("Resultant sum represented as a linked list is: \n");
        solution.printList(head1);
        solution.printList(head2);
        solution.printList(result);
	}

	public void printList(ListNode head) {
        ListNode temp = head;
         
        while (temp != null)
        {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public ListNode addLists(ListNode headNode1, ListNode headNode2) {
    	return addLists(headNode1, headNode2,0);
    }
	public ListNode addLists(ListNode node1, ListNode node2, int carry) {
		if (node1 == null && node2 == null) {
			if (carry > 0) {
				return new ListNode(carry);
			}
			return null;
		}

		int value1 = (node1 != null) ? node1.value:0;
		int value2 = (node2 != null) ? node2.value:0;
		
		System.out.println("value1: "+value1+" value2: "+value2+" carry: "+carry);
		
		int sum = (value1+value2+carry)%10;
		carry = (value1+value2+carry)/10;

		ListNode resultList = new ListNode(sum);

		ListNode node1Next = (node1 != null) ? node1.next : null;
		ListNode node2Next = (node2 != null) ? node2.next : null;

		resultList.next = addLists(node1Next, node2Next, carry);
		return resultList;
	}

	ListNode head;
	ListNode tail;

	private void appendNode(int value){
		if (head == null) {
			head = new ListNode(value);
			tail = head;
			return;
		}
		ListNode n = new ListNode(value);
		n.next = head;
		head = n;
	}

	public ListNode createLinkedList(int[] number){
		if (head != null) {
			head = null;
		}
		for (int i = 0; i < number.length; i++) {
			appendNode(number[i]);
		}
		return head;
	}

	private class ListNode {
        int value;
        ListNode next;
 
        ListNode(int value)
        {
            this.value = value;
        }
    }
}