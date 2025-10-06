//Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class file4 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node before the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pointers
        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (true) {
            // Check if there are k nodes to reverse
            ListNode kthNode = getKthNode(current, k);
            if (kthNode == null) break;

            ListNode nextGroupStart = kthNode.next;

            // Reverse k nodes
            ListNode prev = null;
            ListNode curr = current;
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect with previous group
            prevGroupEnd.next = kthNode;
            current.next = nextGroupStart;

            // Move to next group
            prevGroupEnd = current;
            current = nextGroupStart;
        }

        return dummy.next;
    }

    // Helper to get the kth node from current
    private ListNode getKthNode(ListNode start, int k) {
        while (start != null && k > 1) {
            start = start.next;
            k--;
        }
        return start;
    }

    // Helper to create a linked list from array
    public ListNode createList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

   
    public void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

   
    public static void main(String[] args) {
        file4 solution = new file4();

     
        int[] input = {1, 2, 3, 4, 5};
        int k = 3;

        ListNode head = solution.createList(input);

        System.out.print("Original list: ");
        solution.printList(head);

        ListNode result = solution.reverseKGroup(head, k);

        System.out.print("Reversed in k-group: ");
        solution.printList(result);
    }
}
