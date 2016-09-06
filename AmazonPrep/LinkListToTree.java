public class LinkListToTree {

	private ListNode head = null;
	private ListNode tail = null;

	public void addToList(int data){
		ListNode n = new ListNode(data);
		if (head == null) {
			head = n;
			tail = n;
		} else {
			n.prev = tail;
			tail.next = n;
			tail = n;
		}
	}

	private int getListLength() {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

	public void convertToTree(){
		int length = getListLength();
		head = convertToTree(length);
		tail = null;
	}

	private ListNode convertToTree(int length){
		if (length == 0) {
			return null;
		}

		ListNode left = convertToTree(length/2);
		ListNode root = head;
		root.prev = left;
		head = head.next; 
		ListNode right = convertToTree(length - (length/2) -1);
		root.next = right;
		return root;
	}

	public void printInorderOrderTraversal() {
        printInorderOrderTraversalHelper(head);
    }
 
    private void printInorderOrderTraversalHelper(ListNode root) {
        if (root == null) {
            return;
        }
 
        printInorderOrderTraversalHelper(root.prev);
        System.out.print(root.data + " ");
        printInorderOrderTraversalHelper(root.next);
    }

	public static void main(String[] args) {
		LinkListToTree list = new LinkListToTree();
		for (int i=1; i<8; i++) {
			list.addToList(i);
		}
		list.covertToTree();
		list.printTree();
	}
}


class ListNode {
	int data;
	ListNode prev;
	ListNode next;

	public ListNode(int data){
		this.data = data;
	}
}